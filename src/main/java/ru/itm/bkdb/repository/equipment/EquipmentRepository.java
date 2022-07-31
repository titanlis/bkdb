package ru.itm.bkdb.repository.equipment;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.equipment.Equipment;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface EquipmentRepository extends CommonRepository<Equipment> {
}
