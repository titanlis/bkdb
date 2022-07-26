package ru.itm.bkdb.entity.tables.sensor;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_data_types", schema = "sensor")
public final class SensorDataType extends AbstractEntity {
	private String name;
	public SensorDataType(){}
}
