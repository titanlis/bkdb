package ru.itm.bkdb.repository.sensor;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.sensor.SensorType;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface SensorTypeRepository extends CommonRepository<SensorType> {
}
