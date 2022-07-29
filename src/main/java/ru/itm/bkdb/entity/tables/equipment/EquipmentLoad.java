package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_load", schema = "equipment")
public class EquipmentLoad  extends AbstractEntity {

	@Column(name = "equip_id")
	private Long equipmentId;
	
	@Column(name = "radius_load")
	private float radiusLoad;
	
	@Column(name = "radius_wait")
	private float radiusWait;
	
	@Column(name = "radius_bucket")
	private Float radiusBucket;

	public EquipmentLoad() {
	}

	@Override
	public String toStringShow() {
		return null;
	}
}
