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
import ru.itm.bkdb.serivce.UpdateService;
import ru.itm.bkdb.udp.DBModelContainer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Основной контроллер сервиса
 */
@RestController
@RequestMapping("/api/v1/")
public class UpdateController {
    private static Logger logger = LoggerFactory.getLogger(UpdateController.class);
    private final UpdateService updateService;

    @Autowired
    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    /**
     * Проверка необходимости обновления таблиц и запуск самого обновления устаревших таблиц.
     * Запускается по таймеру или по ендпоинту /update при ручной команде оператора.
     */
    @GetMapping("/update")
    public void updateTablesSearch(){
        updateService.updateTablesSearch();
    }

}
