package ru.itm.bkdb.entity.tables.equipment;

import lombok.Data;
import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name="equip_type", schema = "equipment")
public class EquipmentType extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	private EQUIPMENT_TYPE name;
	private String descr;
	private boolean active;
	
	public EquipmentType() {
		
	}

	@Override
	public String toStringShow() {
		return "Equipment [id=" + id + ", name=" + name + ", descr=" + descr
				+ ", active=" + active + "]";
	}

	public EQUIPMENT_TYPE getName() {
		return name;
	}

	public void setName(EQUIPMENT_TYPE name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
