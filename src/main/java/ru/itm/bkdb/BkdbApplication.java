package ru.itm.bkdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BkdbApplication {

    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(BkdbApplication.class);
        SpringApplication.run(BkdbApplication.class, args);
    }

}
