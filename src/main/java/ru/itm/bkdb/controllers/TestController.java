package ru.itm.bkdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.itm.bkdb.entity.TableVersion;
import ru.itm.bkdb.serivce.TablesService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Класс для "ручной" поверки некоторых методов сервиса
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TablesService tablesService;

    @GetMapping("/trigger_trans_cycles")
    public void triggerTransCycles(){
         System.out.println("trigger_trans_cycles");
    }

    /**
     * Вывод всех таблиц с версиями
     */
    @GetMapping("/getalltables")
    public void stopPage(){
        int i=1;
        List<TableVersion> tablesFromH2 = tablesService.findAll();
        for(TableVersion t:tablesFromH2){
            System.out.println(t.toStringShort());
            //System.out.println(""+(i++)+" " +t);
        }
    }

    /**
     * Обновить базы
     */
    @GetMapping("/update")
    public void changeTab(){
        List<TableVersion> tableVersions = tablesService.findAll();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Integer> map = new LinkedMultiValueMap();
        tableVersions.stream().forEach(t-> {
            map.add(t.getTableName(), t.getTableVersion());
        });

        HttpEntity<MultiValueMap<String, Integer>> request = new HttpEntity<MultiValueMap<String, Integer>>(map, headers);

        logger.info("Запрос готов");
        ResponseEntity<MultiValueMap> response = restTemplate.postForEntity( "http://localhost:8090/api/v1/192.168.1.13/findtables", request , MultiValueMap.class );
        logger.info("Запрос ушел");
        logger.info("Ответ : " + response.getBody());

    }

}
