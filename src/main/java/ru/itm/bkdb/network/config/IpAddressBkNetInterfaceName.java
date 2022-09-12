package ru.itm.bkdb.network.config;

import org.springframework.beans.factory.annotation.Value;
import ru.itm.bkdb.network.utils.NetInterface;
import ru.itm.bkdb.network.utils.NetworkUtils;

import javax.annotation.PostConstruct;
import java.net.ConnectException;
import java.util.List;
import java.util.Optional;

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

    /**
     * Инициализация сетевого интерфейса
     * Назначает активный интерфейс рабочим и определяет его ip и mac
     * @throws ConnectException
     */
    @PostConstruct
    public void init() throws ConnectException {
        if(NetworkUtils.isPhysicalActiveInterface(wifi)){
            netInterfaceName = wifi;
        }
        else if(NetworkUtils.isPhysicalActiveInterface(lan)){
            netInterfaceName = lan;
        }
        else{
            Optional<NetInterface> opt = NetworkUtils.getActiveInterfacesIPv4().stream()
                    .filter(netInterface->!netInterface.getMac().equals("00:00:00:00:00:00"))
                    .findFirst();

            if(opt.isEmpty()){
                throw new ConnectException("No active net interfaces in property.");
            }
            else{
                netInterfaceName = opt.get().getName();
            }
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
