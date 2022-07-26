package ru.itm.bkdb.controllers;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.itm.bkdb.entity.TableVersion;
import ru.itm.bkdb.entity.tables.config.ValuesData;
import ru.itm.bkdb.entity.tables.operator.Act;
import ru.itm.bkdb.entity.tables.operator.ActToRole;
import ru.itm.bkdb.entity.tables.operator.Role;
import ru.itm.bkdb.kryo.KryoSerializer;
import ru.itm.bkdb.network.Request;
import ru.itm.bkdb.network.config.IpAddressBk;
import ru.itm.bkdb.repository.config.ValuesDataRepository;
import ru.itm.bkdb.repository.operator.ActRepository;
import ru.itm.bkdb.repository.operator.ActToRoleRepository;
import ru.itm.bkdb.repository.operator.RoleRepository;
import ru.itm.bkdb.serivce.TablesService;
import ru.itm.bkdb.udp.DBModelContainer;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Основной контроллер сервиса
 */
@RestController
@RequestMapping("/api/v1/")
public class UpdateController {
    private static Logger logger = LoggerFactory.getLogger(UpdateController.class);

    /** Сервис работы с БД H2*/
    private TablesService tablesService;
    @Autowired
    public void setTablesService(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    /**Сетевые утилиты*/
    private IpAddressBk ipAddressBk;
    @Autowired
    public void setIpAddressBk(IpAddressBk ipAddressBk) {
        this.ipAddressBk = ipAddressBk;
    }

    @Value("${server.main_server_name}"+":"+"${server.main_server_port}")
    private String serverUrl;

    /**Время следующего обновления*/
    private Instant nextUpdateTime = Instant.now();

    /**Через сколько секунд происходит плановое обновление*/
    @Value("${period.update}")
    private long period;


    private ActRepository actRepository;
    @Autowired
    public void setActRepository(ActRepository actRepository) {
        this.actRepository = actRepository;
    }

    private ActToRoleRepository actToRoleRepository;
    @Autowired
    public void setActRepository(ActToRoleRepository actToRoleRepository) {
        this.actToRoleRepository = actToRoleRepository;
    }

    private RoleRepository roleRepository;
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private ValuesDataRepository valuesDataRepository;
    @Autowired
    public void setValuesDataRepository(ValuesDataRepository valuesDataRepository) {
        this.valuesDataRepository = valuesDataRepository;
    }
    /**
     * Запускается с задержкой 10с проверка необходимости обновления баз
     * на случай оффлайна. При выходе из оффлайна максимум через 10с базы обновятся.
     */
    @Scheduled(fixedDelay = 1)
    private void updateProcessStart(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.info("Thread.sleep(10000) прерван.");
        }
        /**Сравниваем запланированное время обновления с текущим временем, если пора,
         * то запускаем проверку обновления*/
        if(nextUpdateTime.getEpochSecond()<=Instant.now().getEpochSecond()){
            updateTablesSearch();
        }
    }


    /**
     * Проверка необходимости обновления таблиц и запуск самого обновления устаревших таблиц.
     * Запускается по таймеру или по ендпоинту /update при ручной команде оператора.
     */
    @GetMapping("/update")
    public void updateTablesSearch(){
        /**Читаем все данные по версиям из базы в лист*/
        List<TableVersion> tableVersions = tablesService.findAll();

        tmpPrintTables(tableVersions);  //в релизе убрать!! Лог таблиц из h2 с версиями

        /**Синхронный клиент для выполнения HTTP-запросов, предоставляющий простой шаблон API
         *        метода поверх базовых клиентских библиотек HTTP, таких как JDK HttpURLConnection,
         *        Apache HttpComponents и другие.
         */
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        /**Создаем пары для отправки "имя таблицы"-"версия"*/
        MultiValueMap<String, Integer> map = new LinkedMultiValueMap();
        tableVersions.stream().forEach(t-> {
            map.add(t.getTableName(), t.getTableVersion());
        });

        String urlFull = "http://" + serverUrl+"/api/v1/" + ipAddressBk.getIp() + "/gettabversions";
        /**Создаем post запрос и отправляем пары на сервер*/
        try {
            HttpEntity<MultiValueMap<String, Integer>> request = new HttpEntity<MultiValueMap<String, Integer>>(map, headers);
            /**Возвращаются пары с именами таблиц и версиями, которые новее*/
            ResponseEntity<MultiValueMap> response
                    = restTemplate.postForEntity( urlFull, request , MultiValueMap.class );
            logger.info("Ответ. Начинаем обновление этих таблиц :\n\t " + response.getBody());

            response.getBody().keySet().stream().forEach(tableName-> {
                        String tableNameResponse = String.valueOf(tableName).toLowerCase();
                        System.out.println("Обновляем " + tableNameResponse);
                        System.out.println("http://" + serverUrl + "/api/v1/"
                                + ipAddressBk.getIp() + "/update/" + tableName);

                        DBModelContainer dbModelContainer = Request.get("http://" + serverUrl + "/api/v1/"
                                + ipAddressBk.getIp() + "/update/" + tableName);

                        if(dbModelContainer!=null){
                            switch (tableNameResponse) {
                                case "acts" -> {
                                    actRepository.deleteAll();
                                    dbModelContainer.getData().stream().forEach(bytesArray -> {
                                        Act deserialize = (Act) KryoSerializer.deserialize(bytesArray);
                                        System.out.println(deserialize.toStringShow());
                                        actRepository.save(deserialize);
                                    });
                                }
                                case "acts_to_roles" -> {
                                    actToRoleRepository.deleteAll();
                                    dbModelContainer.getData().stream().forEach(bytesArray -> {
                                        ActToRole deserialize = (ActToRole) KryoSerializer.deserialize(bytesArray);
                                        System.out.println(deserialize.toStringShow());
                                        actToRoleRepository.save(deserialize);
                                    });
                                }
                                case "roles" -> {
                                    roleRepository.deleteAll();
                                    dbModelContainer.getData().stream().forEach(bytesArray -> {
                                        Role deserialize = (Role) KryoSerializer.deserialize(bytesArray);
                                        System.out.println(deserialize.toStringShow());
                                        roleRepository.save(deserialize);
                                    });
                                }
                                case "values_data" -> {
                                    try {
                                        valuesDataRepository.deleteAll();
                                        dbModelContainer.getData().stream().forEach(bytesArray -> {
                                            ValuesData deserialize = (ValuesData) KryoSerializer.deserialize(bytesArray);
                                            System.out.println(deserialize.toStringShow());
                                            valuesDataRepository.save(deserialize);
                                        });                                    }catch (Exception e){
                                        System.out.println("Надо бы создать таблицу");
                                    }
                                }

                                default -> logger.info("No table to update was found.");
                            }

                            updateVersion(tableVersions,
                                    tableNameResponse,
                                    Integer.valueOf(String.valueOf(response.getBody().getFirst(tableNameResponse))));
                        }
                    });

            /**После обновления устанавливаем время следующего планового обновления*/
            nextUpdateTime = nextUpdateTime.plusSeconds(period);

        } catch (ResourceAccessException e) {
            logger.error("Connect exception \'" + urlFull +"\'");
            logger.info("Ожидаем выхода из offline");
        }
        logger.info("Все бызы обновлены");
    }

    /**
     * Вывод списка версий на экран
     * @param tableVersions
     * @warning Удалить из релиза
     */
    private void tmpPrintTables(List<TableVersion> tableVersions) {
        AtomicInteger i= new AtomicInteger(1);
        tableVersions.stream().forEach(t->{
            System.out.println((i.getAndIncrement()) + "\t" + t.getTableName() + "\t" + t.getTableVersion());
        });
    }

    /**
     * Обновить версию в таблице TableVersion
     * @param tableVersions список с версиями
     * @param tableName имя таблицы
     * @param newVersion новая версия таблицы
     */
    private void updateVersion(List<TableVersion> tableVersions, String tableName, Integer newVersion){
        /**Находим строку с нужным именем таблицы*/
        TableVersion t = tableVersions.stream()
                .filter(tableVersion->tableVersion.getTableName().equals(tableName))
                .findFirst()
                .orElse(null);

        /**Установим в нее новую версию*/
        t.setTableVersion(newVersion);
        /**Обновим строку в базе*/
        tablesService.save(t);
        logger.info(tableName + " = " + newVersion + " TableVersions в базе обновили");
    }
}
