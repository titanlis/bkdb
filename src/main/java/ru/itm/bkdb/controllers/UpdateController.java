package ru.itm.bkdb.controllers;

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
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.entity.TableVersion;
import ru.itm.bkdb.entity.tables.config.ValuesData;
import ru.itm.bkdb.entity.tables.dispatcher.Dispatcher;
import ru.itm.bkdb.entity.tables.drilling.Hole;
import ru.itm.bkdb.entity.tables.drilling.HoleStatus;
import ru.itm.bkdb.entity.tables.location.Location;
import ru.itm.bkdb.entity.tables.operator.Act;
import ru.itm.bkdb.entity.tables.operator.ActToRole;
import ru.itm.bkdb.entity.tables.operator.Role;
import ru.itm.bkdb.kryo.KryoSerializer;
import ru.itm.bkdb.network.Request;
import ru.itm.bkdb.network.config.IpAddressBk;
import ru.itm.bkdb.repository.CommonRepository;
import ru.itm.bkdb.repository.RepositoryFactory;
import ru.itm.bkdb.repository.config.ValuesDataRepository;
import ru.itm.bkdb.repository.dispatcher.DispatcherRepository;
import ru.itm.bkdb.repository.drilling.HoleRepository;
import ru.itm.bkdb.repository.drilling.HoleStatusRepository;
import ru.itm.bkdb.repository.location.LocationRepository;
import ru.itm.bkdb.repository.operator.*;
import ru.itm.bkdb.serivce.TablesService;
import ru.itm.bkdb.udp.DBModelContainer;

import java.time.Instant;
import java.util.ArrayList;
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

    private CommonRepository commonRepository;


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
        /**Для имен таблиц, которые не обновились*/
        List<String> listTableNameNoUpdates = new ArrayList<>();


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
                            List<AbstractEntity> abstractEntityList = new ArrayList<>();
                            commonRepository = this.updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                            switch (tableNameResponse) {
//                                case "acts" -> {
//                                    commonRepository = this.<Act>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "acts_to_roles" -> {
//                                    commonRepository = this.<ActToRole>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "roles" -> {
//                                    commonRepository = this.<Role>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "values_data" -> {
//                                    commonRepository = this.<ValuesData>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "dispatcher" -> {
//                                    commonRepository = this.<Dispatcher>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "location" -> {
//                                    commonRepository = this.<Location>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "holes" -> {
//                                    commonRepository = this.<Hole>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                case "hole_status" -> {
//                                    commonRepository = this.<HoleStatus>updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
//                                }
//                                default -> logger.info("No table to update was found.");
//                            }
                            if(!abstractEntityList.isEmpty()){
                                commonRepository.deleteAll();
                                commonRepository.saveAll(abstractEntityList);
                                updateVersion(tableVersions,
                                        tableNameResponse,
                                        Integer.valueOf(String.valueOf(response.getBody().getFirst(tableNameResponse))));
                                logger.info("База " + tableName + " обновлена");
                            }
                            else{
                                listTableNameNoUpdates.add(tableNameResponse);
                            }
                        }
                    });

            /**После обновления устанавливаем время следующего планового обновления*/
            nextUpdateTime = nextUpdateTime.plusSeconds(period);

        } catch (ResourceAccessException e) {
            logger.error("Connect exception \'" + urlFull +"\'");
            logger.info("Ожидаем выхода из offline");
        }
        if(listTableNameNoUpdates.isEmpty()){
            logger.info("Все базы обновлены");
        }
        else {
            logger.info("Базы не обновлены:");
            listTableNameNoUpdates.stream().forEach(t->logger.info(t));
        }
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

    private <T> CommonRepository updateTable(DBModelContainer dbModelContainer,
                                             List<AbstractEntity> abstractEntityList,
                                             String tableNameResponse){
        try {
            dbModelContainer.getData().stream().forEach(bytesArray -> {
                T deserialize = (T) KryoSerializer.deserialize(bytesArray);
                System.out.println(((AbstractEntity)deserialize).toStringShow());
                abstractEntityList.add((AbstractEntity) deserialize);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Надо бы создать таблицу");
        }
        return RepositoryFactory.getRepo(tableNameResponse);
    }

}
