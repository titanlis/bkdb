package ru.itm.bkdb.serivce.equipment;

import org.springframework.stereotype.Service;
import ru.itm.bkdb.entity.tables.equipment.Equipment;
import ru.itm.bkdb.repository.equipment.EquipmentRepository;
import ru.itm.bkdb.serivce.AbstractService;

@Service
public class EquipmentService extends AbstractService<Equipment, EquipmentRepository> {

    public EquipmentService(EquipmentRepository repository) {
        super(repository);
    }
}
