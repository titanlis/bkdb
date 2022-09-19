package ru.itm.bkdb.entity.tables.trans;

import ru.itm.bkdb.entity.AbstractEntity;

public interface Trans {
    public boolean isForWrite(AbstractEntity abstractEntity);
}
