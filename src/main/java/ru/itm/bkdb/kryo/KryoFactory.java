package ru.itm.bkdb.kryo;


import com.esotericsoftware.kryo.kryo5.Kryo;
import ru.itm.bkdb.entity.tables.config.ValuesData;
import ru.itm.bkdb.entity.tables.operator.Act;
import ru.itm.bkdb.entity.tables.operator.ActToRole;
import ru.itm.bkdb.entity.tables.operator.Role;

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
        kryo.register(ActToRole.class);
        kryo.register(Role.class);
        kryo.register(ValuesData.class);

        return kryo;
    }

}