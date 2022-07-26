package ru.itm.bkdb.entity.tables.sensor;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_types", schema = "sensor")
public final class SensorType extends AbstractEntity {
	private String name;
	public SensorType(){}
}
