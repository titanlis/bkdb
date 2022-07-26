package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_haul", schema = "equipment")
public class EquipmentHaul extends AbstractEntity {
	private float volume;
	private float payload;
	
	@Column(name = "empty_weight")
	private Float emptyWeight;
	
	@Column(name = "tire_type")
	private String tireType;
	
	@Column(name = "equip_id")
	private Long equipmentId;

	public EquipmentHaul() {
	}
}
