package ru.itm.bkdb.entity.tables.sensor;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_inclin_calibration", schema = "sensor")
public final class SensorInclineCalibration extends AbstractEntity {
	private Long sensor_id;
	private Double calib_a;
	private Double calib_b;
	private Double calib_c;

	public SensorInclineCalibration(){}

	@Override
	public String toString() {
		return "sensor.sensor_types{" +
				"id=" + id +
				", sensor_id=" + sensor_id +
				", calib_a=" + calib_a +
				", calib_b=" + calib_b +
				", calib_c=" + calib_c +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(Long sensor_id) {
		this.sensor_id = sensor_id;
	}

	public Double getCalib_a() {
		return calib_a;
	}

	public void setCalib_a(Double calib_a) {
		this.calib_a = calib_a;
	}

	public Double getCalib_b() {
		return calib_b;
	}

	public void setCalib_b(Double calib_b) {
		this.calib_b = calib_b;
	}

	public Double getCalib_c() {
		return calib_c;
	}

	public void setCalib_c(Double calib_c) {
		this.calib_c = calib_c;
	}
}
