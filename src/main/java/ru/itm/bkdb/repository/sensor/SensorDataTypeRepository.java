package ru.itm.bkdb.repository.sensor;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.sensor.SensorDataType;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface SensorDataTypeRepository extends CommonRepository<SensorDataType> {
}
