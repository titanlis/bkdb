package ru.itm.bkdb.entity.tables.tire;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tire_assign", schema = "tire")
public final class TireAssign extends AbstractEntity {
	@Column(name = "tire_id")
	private Long tireId;
	
	@Column(name = "equip_id")
	private Long equipId;
	
	@Column(name = "tire_storage_id")
	private Long tireStorageId;
	
	private Integer position;
	
	@Column(name = "time_assign")
	private String timeAssign;
	
	@Column(name = "sensor_id")
	private Long sensorId;
	
}
