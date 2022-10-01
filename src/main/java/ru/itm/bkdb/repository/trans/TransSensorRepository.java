package ru.itm.bkdb.repository.trans;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.trans.TransSensor;
import ru.itm.bkdb.repository.CommonRepository;

import java.util.Calendar;

@Repository
public interface TransSensorRepository extends CommonRepository<TransSensor> {
    Integer countAllByEquipIdAndTimeRead(Long equip_id, Calendar time_read);
}