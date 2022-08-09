package ru.itm.bkdb.repository.sensor;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.sensor.SensorInclineCalibration;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface SensorInclineCalibrationRepository extends CommonRepository<SensorInclineCalibration> {
}
