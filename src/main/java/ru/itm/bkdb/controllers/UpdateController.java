package ru.itm.bkdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.dao.DataIntegrityViolationException;
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
import ru.itm.bkdb.config.SystemConfig;
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.entity.MessageStatus;
import ru.itm.bkdb.entity.TableVersion;
import ru.itm.bkdb.kryo.CompressObject;
import ru.itm.bkdb.kryo.KryoSerializer;
import ru.itm.bkdb.network.Request;
import ru.itm.bkdb.network.config.IpAddressBk;
import ru.itm.bkdb.repository.CommonRepository;
import ru.itm.bkdb.repository.RepositoryFactory;
import ru.itm.bkdb.serivce.TablesService;
import ru.itm.bkdb.udp.DBModelContainer;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

    /**Сервис запущен через init?*/
    @Value("${init}")
    private boolean init;

    /**Url актуатора init?*/
    @Value("${init.actuator.url}")
    private String initActuatorUrl;

    private CommonRepository commonRepository;


    /**
     * Автозапуск после создания контекста
     */
    @EventListener(ApplicationReadyEvent.class)
    private void startIni(){
        initActuatorUrl = "http://localhost:10056/actuator/health";
        System.out.println("init = " + init);
        if(init){
            /**Раз в 20 сек пингуем инит. Если он вылетел, то выключаем сервис.*/
            Runnable task = () -> {
                logger.info("InitPing started");
                while(!SystemConfig.isNeedStop()){
                    try {
                        TimeUnit.SECONDS.sleep(20L);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.print("BCUpdate : isInitActive() ... ");
                    if(isInitActive()){
                        System.out.println("ping init OK!");
                    }
                    else{
                        System.out.println("ping init BAD!");
                        break;
                    }
                }
                logger.info("InitPing closed");
                try{
                    exit();
                }catch (IllegalStateException ex){
                    logger.info("--- init is closed ---");
                }

            };
            Thread thread = new Thread(task);
            thread.setDaemon(true); //сработает даже без daemon, но так проще
            thread.start();
        }
    }

    private boolean isInitActive(){
        System.out.println("ping init");
        try{
            MessageStatus messageStatus = Request.getMessageStatus(initActuatorUrl);
            return messageStatus.getStatus().toLowerCase().equals("up");
        }catch (ResourceAccessException e){}
        return false;
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
        /**Для имен таблиц, которые не обновились*/
        List<String> listTableNameNoUpdates = new ArrayList<>();

        Boolean online = true;


        /**Читаем все данные по версиям из базы в лист*/
        List<TableVersion> tableVersions = tablesService.findAll();

        tmpPrintTables(tableVersions);  //в релизе убрать!! Лог таблиц из h2 с версиями

        /**Синхронный клиент для выполнения HTTP-запросов, предоставляющий простой шаблон API
         *        метода поверх базовых клиентских библиотек HTTP, таких как JDK HttpURLConnection,
         *        Apache HttpComponents и другие.
         */
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//.APPLICATION_FORM_URLENCODED);

        /**Создаем пары для отправки "имя таблицы"-"версия"*/
        MultiValueMap<String, Integer> map = new LinkedMultiValueMap();
        tableVersions.stream().forEach(t-> {
            map.add(t.getTableName(), t.getTableVersion());
        });

        String urlFull = "http://" + serverUrl+"/api/v1/" + ipAddressBk.getIp() + "/gettabversions";

        /**Массив для сжатой gzip мэпой с именами и версиями таблиц*/
        byte[] arrayAllTab = new byte[0];
        try {
            arrayAllTab = CompressObject.writeCompressObject(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**Создаем post запрос и отправляем массив байт с парами (имя, версия) на сервер*/
        try {

            HttpEntity<byte[]> request = new HttpEntity<>(arrayAllTab, headers);

            /**Возвращаются пары с именами таблиц и версиями, которые новее в архиве gzip*/
            ResponseEntity<byte[]> response = restTemplate.postForEntity( urlFull, request , byte[].class );

            /**Вытаскиваем их из архива*/
            MultiValueMap<String, Integer> mapNew = (MultiValueMap<String, Integer>)CompressObject.readCompressObject(response.getBody());

            logger.info("Response. Begin updating these tables :\n\t " + mapNew);
            online = true;

            if(response.hasBody()){
                mapNew.keySet().stream().forEach(tableName-> {
                    String tableNameResponse = String.valueOf(tableName).toLowerCase();
                    System.out.println("\nUpdate the table : " + tableNameResponse);
                    System.out.println("http://" + serverUrl + "/api/v1/"
                            + ipAddressBk.getIp() + "/update/" + tableName);

                    /**Запрос на обновление таблицы. В ответе список строк таблицы.*/
                    DBModelContainer dbModelContainer = Request.get("http://" + serverUrl + "/api/v1/"
                            + ipAddressBk.getIp() + "/update/" + tableName, tableName);

                    if(dbModelContainer!=null){
                        List<AbstractEntity> abstractEntityList = new ArrayList<>();
                        /**Обновим таблицу*/
                        commonRepository = this.updateTable(dbModelContainer, abstractEntityList, tableNameResponse);
                        if(!abstractEntityList.isEmpty()){
                            try {
                                commonRepository.deleteAll();
                            }catch (DataIntegrityViolationException ex){
                                System.out.println("Delete exception : " + ex);
                            }

                            commonRepository.saveAll(abstractEntityList);
                            updateVersion(tableVersions,
                                    tableNameResponse,
                                    Integer.valueOf(String.valueOf(mapNew.getFirst(tableNameResponse))));
                            logger.info("Table \'" + tableName + "\'  has been updated.");
                        }
                        else{
                            listTableNameNoUpdates.add(tableNameResponse);
                        }
                    }
                });
            }
            else{
                logger.info("There are no updates.");
            }

            /**После обновления устанавливаем время следующего планового обновления*/
            nextUpdateTime = nextUpdateTime.plusSeconds(period);

        } catch (ResourceAccessException | IOException | ClassNotFoundException e) {
            logger.error("Connect exception \'" + urlFull +"\'");
            logger.info("Waiting to go offline");
            online = false;
        }
        if(online){
            if(listTableNameNoUpdates.isEmpty()){
                logger.info("All tables have been updated");
            }
            else {
                logger.info("These tables are not updated : ");
                listTableNameNoUpdates.stream().forEach(t->logger.info(t));
            }
        }
        else{
            nextUpdateTime = Instant.now();
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
        logger.info(tableName + " = " + newVersion + " in (TableVersion). The version of the table in the database has been updated.");
    }

    /**
     * Обновление таблицы
     * @param dbModelContainer список с массивами байт (строками таблицы) в kryo и имя таблицы
     * @param abstractEntityList список строк таблицы для заполнения
     * @param tableNameResponse имя текущей таблицы
     * @return  репозиторий физической таблицы в h2
     * @param <T>
     */
    private <T> CommonRepository updateTable(DBModelContainer dbModelContainer,
                                             List<AbstractEntity> abstractEntityList,
                                             String tableNameResponse){
        try {
            dbModelContainer.getData().stream().forEach(bytesArray -> {
                T deserialize = (T) KryoSerializer.deserialize(bytesArray);
                System.out.println(((AbstractEntity)deserialize).toStringShow());
                abstractEntityList.add((AbstractEntity) deserialize);   //
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem with the table.");
        }
        return RepositoryFactory.getRepo(tableNameResponse);
    }

    private void exit() {
        new ShutdownManager().stopPage();
    }

}
