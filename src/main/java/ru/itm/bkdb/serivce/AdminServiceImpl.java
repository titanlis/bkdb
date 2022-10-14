package ru.itm.bkdb.serivce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.kryo.CompressObject;
import ru.itm.bkdb.kryo.KryoSerializer;
import ru.itm.bkdb.repository.CommonRepository;
import ru.itm.bkdb.repository.RepositoryFactory;
import ru.itm.bkdb.repository.trans.TransCycleRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AdminServiceImpl implements AdminService {
    private static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    private static TransCycleRepository transCycleRepository;
    private static String[] tablesTrans = {"trans_cycles", "trans_refuel"};
    private String transString = "no data";
    private String updateTablesString = "no data";
    @Value("${server.main_server_name}"+":"+"${server.main_server_port}")
    private String serverUrl;

    private final UpdateService updateService;

    @Autowired
    public AdminServiceImpl(TransCycleRepository transCycleRepository, UpdateService updateService) {
        this.transCycleRepository = transCycleRepository;
        this.updateService = updateService;
    }

    @Override
    public String sendAll(String name){
        logger.info(name);
        transString = "no data";
        StringBuffer returnString = new StringBuffer("");

//        CommonRepository commonRepository = switch (name){
//            case "trans_cycles" -> transCycleRepository;
//            default -> null;
//        };

        CommonRepository commonRepository = RepositoryFactory.getRepo(name);

        if(commonRepository==null){
            logger.warn("commonRepository==null");
            return transString;
        }

        Map<String, List<byte[]>> tablesMap = new HashMap<>();              //для таблиц со сжатием
        Map<String, Iterable<AbstractEntity>> tablesList = new HashMap<>(); //для таблиц без сжатия

        List<byte[]> listEntity = new ArrayList<>();
        System.out.println("Repo : " + name);
        Iterable<AbstractEntity> abstractEntities = commonRepository.findAll();
        AtomicReference<Boolean> isNoOne = new AtomicReference<>(false);

        /**Если таблица не пуста*/
        if(((List)abstractEntities).size()>0){
            tablesList.put(name, abstractEntities);

            abstractEntities.forEach(abstractEnt -> {
                if(isNoOne.get()){
                    returnString.append("       --->       ");
                }

                isNoOne.set(true);
                returnString.append(abstractEnt.toStringShow());
                System.out.println(abstractEnt.toStringShow());
                listEntity.add(KryoSerializer.serialize(abstractEnt));
            });
            tablesMap.put(name, listEntity);
            System.out.println("End " + name);
        }
        else{
            System.out.println("Empty " + name);
        }

        if(tablesMap.isEmpty()){return transString;}

        try {
            if(sendTrans(CompressObject.writeCompressObject(tablesMap))){       //отпраляем массив с таблицами на сервер
                logger.info("data is write in server");
                /**Разобрали таблицы*/
                tablesList.forEach((names, iterableAbstractEntity) ->{
                    iterableAbstractEntity.forEach(b-> {
//                        commonRepository.delete(b);
                    });
                    logger.info("Table \'"+names+"\' is cleaned.");
                });
            }
            else{
                logger.info("No write");
            }
        } catch (IOException e) {
            logger.error("Compress error:\n" + e.getMessage());
        }

        transString = returnString.toString();
        if(transString.equals("")){
            transString="no data";
        }
        return transString;
    }

    /**
     * Корректное ли имя таблицы. Входит ли она в список таблиц trans_ для передачи
     * @param tab
     * @return
     */
    @Override
    public boolean isTabValid(String tab) {
        for(String table : tablesTrans){
            if(tab.equals(table)) return true;
        }
        return false;
    }

    @Override
    public String getData() {
        return transString;
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

    @Override
    public String updateTables() {
        List<String> listTableNameUpdates = updateService.updateTablesSearch();
        StringBuffer stringBuffer = new StringBuffer("Updates : ");
        if(listTableNameUpdates!=null && listTableNameUpdates.size()>0){
            listTableNameUpdates.stream().forEach(table->{
                stringBuffer.append(table+"\s\\\s");
            });
        }
        else{
            stringBuffer.append(" none ");
        }
        updateTablesString = stringBuffer.toString();
        return updateTablesString;
    }

    @Override
    public String getTables() {
        return updateTablesString;
    }
}
