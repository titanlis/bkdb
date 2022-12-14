package ru.itm.bkdb.serivce;

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
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.itm.bkdb.config.SystemConfig;
import ru.itm.bkdb.controllers.ShutdownManager;
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.entity.MessageStatus;
import ru.itm.bkdb.entity.TableVersion;
import ru.itm.bkdb.kryo.CompressObject;
import ru.itm.bkdb.kryo.KryoSerializer;
import ru.itm.bkdb.network.Request;
import ru.itm.bkdb.network.config.IpAddressBk;
import ru.itm.bkdb.repository.CommonRepository;
import ru.itm.bkdb.repository.RepositoryFactory;
import ru.itm.bkdb.repository.TableRepository;
import ru.itm.bkdb.udp.DBModelContainer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UpdateService {
    private static Logger logger = LoggerFactory.getLogger(UpdateService.class);
    private static Boolean is10min = false; //обновлять ли 10 минутные таблицы
    private static String [] transTimeArray5min = {
            "trans_fuel","trans_coord", "trans_sensor", "trans_keys_cycle", "trans_keys_drilling"
    };
    private static String []transTimeArray10min = {
            "trans_network"
    };

    @Value("${server.main_server_name}"+":"+"${server.main_server_port}")
    private String serverUrl;

    /**Время следующего обновления*/
    //private Instant nextUpdateTime = Instant.now();
    private LocalDateTime nextUpdateTime = LocalDateTime.now();

    /**Через сколько секунд происходит плановое обновление*/
    @Value("${period.update}")
    private long period;

    /**Сервис запущен через init?*/
    @Value("${init}")
    private boolean init;

    /**Url актуатора init?*/
    @Value("${init.actuator.url}")
    private String initActuatorUrl;

    /**Репозитории обновляемых таблиц*/
    private CommonRepository commonRepository;

    /**Сетевые утилиты*/
    private IpAddressBk ipAddressBk;
    private TablesService tablesService;

    @Autowired
    public UpdateService(IpAddressBk ipAddressBk, TablesService tablesService) {
        this.ipAddressBk = ipAddressBk;
        this.tablesService = tablesService;
    }

    /**
     * Автозапуск после создания контекста
     */
    @EventListener(ApplicationReadyEvent.class)
    private void startIni(){
        initActuatorUrl = "http://localhost:10056/actuator/health";
        logger.info("\ninit = " + init);
        if(init){
            /**Раз в 20 сек пингуем инит. Если он вылетел, то выключаем сервис.*/
            Runnable task = () -> {
                logger.info("InitPing started");
                int i=0;    //число попыток достучаться до инит
                while(!SystemConfig.isNeedStop() && i<5){
                    try {
                        TimeUnit.SECONDS.sleep(20L);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    if(isInitActive()){
                        if(i>0) logger.info("Connection with the INIT is restored.");
                        i=0;
                    }
                    else{
                        if(i==0) logger.info("Ping init BAD!");
                        i++;
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
        //System.out.println("ping init");
        try{
            MessageStatus messageStatus = Request.getMessageStatus(initActuatorUrl);
            return messageStatus.getStatus().toLowerCase().equals("up");
        }catch (ResourceAccessException e){}
        return false;
    }

    /**
     * Запускается с задержкой 5 мин обновление trans_ по времени
     */
    @Scheduled(fixedDelay = 280000)
    private void updateTransTime(){
        try {
            TimeUnit.SECONDS.sleep(20L);
        } catch (InterruptedException e) {
            logger.info("TimeUnit.SECONDS.sleep(20L) прерван.");
        }

        Map<String, List<byte[]>> tablesMap = new HashMap<>();              //для таблиц со сжатием
        Map<String, Iterable<AbstractEntity>> tablesList = new HashMap<>(); //для таблиц без сжатия
//сделать счетчик минут статический и транс синхронизировать с этой отправкой
        is10min=!is10min;
        if(is10min){
            addTablesToSendToServer(transTimeArray10min, tablesList, tablesMap);           //серриализуем таблицы из списка для отправки (добавляем их в tablesMap)
        }

        addTablesToSendToServer(transTimeArray5min, tablesList, tablesMap);           //серриализуем таблицы из списка для отправки (добавляем их в tablesMap)

        try {
            if(!tablesMap.isEmpty()){
                if(sendTrans(CompressObject.writeCompressObject(tablesMap))){       //отпраляем массив с таблицами на сервер
                    logger.info("data is write in server");
                    /**Разобрали таблицы*/
                    tablesList.forEach((names, iterableAbstractEntity) ->{
                        CommonRepository commonRepository = RepositoryFactory.getRepo(names);

                        iterableAbstractEntity.forEach(b-> {
                            commonRepository.delete(b);
                        });
                        logger.info("Table \'"+names+"\' is cleaned.");
                    });
                }
                else{
                    logger.info("No write");
                }
            }
            else{
                logger.info("No tables trans_ for update");
            }
        } catch (IOException e) {
            logger.error("Compress error:\n" + e.getMessage());
        }

    }

    /**
     * По списку таблиц серриализуем какие нужно строки, добавляем их в Map для отправки на сервер
     * @param transTimeArray массив с именами транс таблиц
     * @param tablesList    таблицы без сжатия <имя, список строк>
     * @param tablesMap     таблицы сжатая krio <имя, список строк сжатых в массивы байт>
     * @return количество добавленных таблиц
     */
    private int addTablesToSendToServer(String[] transTimeArray, Map<String,
            Iterable<AbstractEntity>> tablesList, Map<String, List<byte[]>> tablesMap) {
        int startSize = tablesMap.size();
        /**Все имена таблиц*/
        Arrays.stream(transTimeArray).forEach(name->{
            /**Для каждого имени находим репозиторий*/
            //CommonRepository
            commonRepository = RepositoryFactory.getRepo(name);
            if(commonRepository!=null){
                List<byte[]> listEntity = new ArrayList<>();        //список записей таблицы name сериализованных krio
                System.out.println("Repo : " + name);
                Iterable<AbstractEntity> abstractEntities = commonRepository.findAll(); //читаем все записи из таблицы

                /**Уберем из списка незакрытые записи*/
                abstractEntities = StreamSupport.stream(abstractEntities.spliterator(), false)
                        .filter(a->a.isEnding())
                        .collect(Collectors.toList());

                /**Если таблица не пуста*/
                if(((List)abstractEntities).size()>0){
                    tablesList.put(name, abstractEntities);

                    abstractEntities.forEach(abstractEnt -> {
                        System.out.println(abstractEnt.toStringShow());
                        listEntity.add(KryoSerializer.serialize(abstractEnt));
                    });
                    tablesMap.put(name, listEntity);
                    System.out.println("End " + name);
                }
                else{
                    System.out.println("Empty " + name);
                }
            }
        });
        return tablesMap.size()-startSize;
    }

    /**
     * Отправить массив с trans таблицыми на сервер http://main:2600/api/v1/trans/update
     * @param arrayToSend массив байт, который отправляется post запросом на сервер.
     * @return
     */
    private boolean sendTrans(byte[] arrayToSend) {
        /**Создаем post запрос и отправляем массив байт с парами (Имя таб, таблицы в виде List<byte[]) на сервер*/
        String urlFull = "http://" + serverUrl + "/api/v1/trans/update";
        System.out.println("size="+arrayToSend.length);
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_FORM_URLENCODED);

            HttpEntity<byte[]> request = new HttpEntity<>(arrayToSend, headers);

            /**Возвращаются 1 или 0 в зависимости от результатов записи в базу*/
            ResponseEntity<Integer> response = restTemplate.postForEntity(urlFull, request, Integer.class);

            logger.info("response.hasBody() && response.getBody() == 1 -> " + (response.hasBody() && response.getBody() == 1));

            return response.hasBody() && response.getBody() == 1;

        }catch (Exception e){
            logger.error("Connect exception \'" + urlFull +"\'");
        }
        return false;
    }


    /**
     * Запускается с задержкой 10с проверка необходимости обновления баз
     * на случай оффлайна. При выходе из оффлайна максимум через 10с базы обновятся.
     */
    @Scheduled(fixedDelay = 10000)
    private void updateProcessStart(){
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            logger.info("Thread.sleep(10000) прерван.");
//        }
        /**Сравниваем запланированное время обновления с текущим временем, если пора,
         * то запускаем проверку обновления*/
        if(nextUpdateTime.isBefore(LocalDateTime.now())){
            //if(nextUpdateTime.getEpochSecond()<=Instant.now().getEpochSecond()){
            updateTablesSearch();
        }
    }


    /**
     * Проверка необходимости обновления таблиц и запуск самого обновления устаревших таблиц.
     * Запускается по таймеру или по ендпоинту /update при ручной команде оператора.
     */
    public List<String> updateTablesSearch(){
        /**Для имен таблиц, которые не обновились*/
        List<String> listTableNameNoUpdates = new ArrayList<>();
        /**Для имен таблиц, которые обновились*/
        List<String> listTableNameUpdates = new ArrayList<>();

        Boolean online = true;

        /**Читаем все данные по версиям из базы в лист*/
        List<TableVersion> tableVersions =  tablesService.findAll();

        //tmpPrintTables(tableVersions);  //в релизе убрать!! Лог таблиц из h2 с версиями

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
                    logger.info("\nUpdate the table : " + tableNameResponse);
                    logger.info("http://" + serverUrl + "/api/v1/"
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
                                logger.error("Delete exception : " + ex);
                            }

                            commonRepository.saveAll(abstractEntityList);
                            updateVersion(tableVersions,
                                    tableNameResponse,
                                    Integer.valueOf(String.valueOf(mapNew.getFirst(tableNameResponse))));
                            logger.info("Table \'" + tableName + "\'  has been updated.");
                            listTableNameUpdates.add(tableName);
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
            //nextUpdateTime = nextUpdateTime.plusSeconds(period);
            getNextTime();

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
            nextUpdateTime = LocalDateTime.now();
        }
        return listTableNameUpdates;
    }

    /**
     * Установка времени следующего обновления. Кратно часу.
     * @return время следующего обновления
     */
    private LocalDateTime getNextTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int h = localDateTime.getHour();
        if(h==23){
            nextUpdateTime = nextUpdateTime.plusDays(1L).withHour(0).withMinute(0).withSecond(0);
        }
        else{
            nextUpdateTime = nextUpdateTime.withHour((h+1)%24).withMinute(0).withSecond(0);
        }

        return nextUpdateTime;
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
                logger.info(((AbstractEntity)deserialize).toStringShow());

                abstractEntityList.add((AbstractEntity) deserialize);   //
            });
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Problem with the table.");
        }
        return RepositoryFactory.getRepo(tableNameResponse);
    }

    private void exit() {
        new ShutdownManager().stopPage();
    }

}
