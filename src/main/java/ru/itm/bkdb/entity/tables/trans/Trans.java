package ru.itm.bkdb.entity.tables.trans;

import ru.itm.bkdb.entity.AbstractEntity;

import java.util.Calendar;

public interface Trans {
    Long getEquipIdTrans();
    Calendar getTime();
    // public boolean isForWrite(AbstractEntity abstractEntity);
}
