package ru.itm.bkdb.serivce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.itm.bkdb.entity.TableVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UpdateService {

    private static Logger logger = LoggerFactory.getLogger(UpdateService.class);

    /**
     * Читаем из БД таблицы, серилизуем их, возвращаем в виде byte[]
     * @param tableVersions
     * @return
     */
    public byte[] getNewSerializableTables(List<TableVersion> tableVersions){
        List<Byte> byteList = new ArrayList<>();

        tableVersions.stream().forEach(tab->{
            byteList.addAll(serializeTab(tab));
        });

        byte[] bt = new byte[byteList.size()];
        AtomicInteger i= new AtomicInteger();
        byteList.stream().forEach(b->{
            bt[i.getAndIncrement()]=b;
        });
        return bt;
    }

    private List<Byte> serializeTab(TableVersion tab) {
        //Читаем таблицу из базы, затем серрилизуем
        return new ArrayList<>(); //не так конечно) Здесь из таблицы делаются байты.
    }
}
