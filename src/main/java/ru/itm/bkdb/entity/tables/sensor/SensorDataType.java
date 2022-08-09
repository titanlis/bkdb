package ru.itm.bkdb.entity.tables.sensor;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_data_types", schema = "sensor")
public final class SensorDataType extends AbstractEntity {
	private String name;
	public SensorDataType(){}

	@Override
	public String toString() {
		return "LisType{" +
				"id=" + id +
				", name=" + name +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
