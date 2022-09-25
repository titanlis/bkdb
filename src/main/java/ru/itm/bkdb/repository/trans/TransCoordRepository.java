package ru.itm.bkdb.repository.trans;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.trans.TransCoord;
import ru.itm.bkdb.repository.CommonRepository;

import java.util.Calendar;

@Repository
public interface TransCoordRepository extends CommonRepository<TransCoord> {
    Integer countAllByEquipIdAndEquipTime(Long equip_id, Calendar equip_time);
}