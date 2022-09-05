package ru.itm.bkdb.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.itm.bkdb.entity.MessageStatus;
import ru.itm.bkdb.kryo.CompressObject;
import ru.itm.bkdb.udp.DBModelContainer;

import java.io.IOException;
import java.util.List;

@Component
public class Request {
    private static RestTemplate restTemplate = new RestTemplate();
    private static Logger logger = LoggerFactory.getLogger(Request.class);

    public static DBModelContainer get(String url, String tableName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        /**Создаем get запрос и отправляем пары на сервер*/
        try {
            HttpEntity<String> request = new HttpEntity<String>("");
            /**Возвращаeтся серилизованная таблица, сжатая gzip*/
            ResponseEntity<byte[]> response
                    = restTemplate.getForEntity( url, byte[].class );


            try {
                DBModelContainer dbModelContainer = new DBModelContainer((List<byte[]>) CompressObject.readCompressObject(response.getBody()), tableName);
                logger.info("Response. The update came :\t " + dbModelContainer);
                return dbModelContainer;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (ResourceAccessException e) {
            logger.error("Connect exception \'" + url +"\'");
        }
        return null;
    }


    public static MessageStatus getMessageStatus(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        /**Создаем get запрос и отправляем пары на сервер*/
        HttpEntity<String> request = new HttpEntity<String>("");
        ResponseEntity<MessageStatus> response
                = restTemplate.getForEntity( url, MessageStatus.class );
        logger.info("Response. The update came :\t " + response.getBody());
        return response.getBody();
    }

}
