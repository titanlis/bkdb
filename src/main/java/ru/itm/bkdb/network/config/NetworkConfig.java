package ru.itm.bkdb.network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.ConnectException;

/**
 * @class NetworkConfig
 * Бины для реализации сценариев инициализации интерфейсов, Ip адреса и поиска MAC.
 */
@Component
public class NetworkConfig {

    /**
     * ip адрес определяется по имени интерфейса к которому подключена сеть
     */
    @Bean
    public IpAddressBk ipAddressBkFromNetworkInterface() throws ConnectException {
        return new IpAddressBkNetInterfaceName();
    }

}