package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name="equip_type", schema = "equipment")
public class EquipmentType extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private EQUIPMENT_TYPE type;
	
	@Column(name = "descr")
	private String description;
	
	private boolean active;
	
	public EquipmentType() {
		
	}
}
