package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_drill", schema = "equipment")
public class EquipmentDrill extends AbstractEntity {
	@Column(name = "type")
	private String type = "TOWER";
	
	@Column(name = "bx_shift")
	private double bxShift;
	
	@Column(name = "by_shift")
	private double byShift;
	
	private double bh;
	
	@Column(name = "H")
	private double height;
	
	private double bc;

	
	@Column(name = "equip_id")
	private Long equipmentId;
	
	
	public EquipmentDrill() {
		
	}

	@Override
	public String toStringShow() {
		return null;
	}
}
