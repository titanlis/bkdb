package ru.itm.bkdb.entity.tables.sensor;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_inclin_calibration", schema = "sensor")
public final class SensorInclineCalibration extends AbstractEntity {
	@Column(name = "sensor_id")
	private Long sensorId;

	@Column(name = "calib_a")
	private Double calibA;

	@Column(name = "calib_b")
	private Double calibB;

	@Column(name = "calib_c")
	private Double calibC;

	public SensorInclineCalibration(){}

	@Override
	public String toStringShow() {
		return null;
	}
}
