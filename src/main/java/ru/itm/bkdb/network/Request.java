package ru.itm.bkdb.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.itm.bkdb.controllers.UpdateController;
import ru.itm.bkdb.udp.DBModelContainer;

@Component
public class Request {
    private static RestTemplate restTemplate = new RestTemplate();
    private static Logger logger = LoggerFactory.getLogger(Request.class);

    public static DBModelContainer get(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        /**Создаем get запрос и отправляем пары на сервер*/
        try {
            HttpEntity<String> request = new HttpEntity<String>("");
            /**Возвращаeтся серилизованная таблица с именем*/
            ResponseEntity<DBModelContainer> response
                    = restTemplate.getForEntity( url, DBModelContainer.class );
            logger.info("Ответ. Обновление пришло :\t " + response.getBody());
            return response.getBody();
        } catch (ResourceAccessException e) {
            logger.error("Connect exception \'" + url +"\'");
        }
        return null;
    }
}
