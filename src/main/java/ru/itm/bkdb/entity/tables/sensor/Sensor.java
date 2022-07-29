package ru.itm.bkdb.entity.tables.sensor;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensors", schema = "sensor")
public final class Sensor extends AbstractEntity {

	@Column(name = "sensor_data_type_id")
	private Long sensorDataTypeId;
	
	@Column(name = "equip_id")
	private Long equipId;
	
	@Column(name = "is_server")
	private boolean isServer;
	
	private String ip;
	
	private String port;
	
	@Column(name = "pin_name")
	private String pinName;
	
	@Column(name = "type_sens")
	private Integer typeSens;
	
	@Column(name = "time_read")
	private Integer timeRead;
	
	@Column(name = "timeout_sens")
	private Integer timeoutSens = 10;
	
	@Column(name = "min_sens")
	private Double minSens;
	
	@Column(name = "max_sens")
	private Double maxSens;
	
	private Integer diff;
	
	@Column(name = "enable_sens")
	private boolean enableSens;

	public Sensor() {}

	@Override
	public String toStringShow() {
		return null;
	}
}
