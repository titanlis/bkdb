package ru.itm.bkdb.network.config;

import org.springframework.beans.factory.annotation.Value;
import ru.itm.bkdb.network.utils.NetworkUtils;

import javax.annotation.PostConstruct;
import java.net.ConnectException;

public class IpAddressBkNetInterfaceName implements IpAddressBk {

    @Value("${bk.netWifi}")
    private String wifi;

    @Value("${bk.netLan}")
    private String lan;

    /**Имя активного сетевого интерфейса*/
    private String netInterfaceName = "";

    private String ip = NetworkUtils.getZeroIp();
    private String mac = NetworkUtils.getZeroMac();

    /**Определим активный интерфейс в конструкторе*/
    public IpAddressBkNetInterfaceName() {

    }

    @PostConstruct
    public void init() throws ConnectException {
        if(NetworkUtils.isPhysicalActiveInterface(wifi)){
            netInterfaceName = wifi;
        }
        else if(NetworkUtils.isPhysicalActiveInterface(lan)){
            netInterfaceName = lan;
        }
        else{
            throw new ConnectException("No active net interfaces in property.");
        }

        ip = NetworkUtils.getIpFromInterfacesName(netInterfaceName);
        mac = NetworkUtils.getMacAddress(ip);
    }

    /**
     * Определяет ip адрес, если известно имя активного интерфейса.
     * @return
     */
    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public String getMAC() {
        return mac;
    }
}
