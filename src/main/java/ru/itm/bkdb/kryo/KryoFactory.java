package ru.itm.bkdb.kryo;


import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.serializers.DefaultSerializers;
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.entity.tables.act.Act;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public abstract class KryoFactory {


    private final static KryoFactory threadFactory = new ThreadLocalKryoFactory();

    protected KryoFactory() {
    }

    public static KryoFactory getDefaultFactory() {
        return threadFactory;
    }

    protected Kryo createKryo() {
        Kryo kryo = new Kryo();
        kryo.register(Act.class);

        return kryo;
    }

}