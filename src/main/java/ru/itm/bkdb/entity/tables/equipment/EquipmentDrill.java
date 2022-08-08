package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_drill", schema = "equipment")
public class EquipmentDrill extends AbstractEntity {
	private Long equip_id;
	private String type = "TOWER";
	private double bx_shift;
	private double by_shift;
	private double bh;
	private double h;
	private double bc;

	public EquipmentDrill() {}

	@Override
	public String toString() {
		return "equipment.equipment_drill [id=" + id + ", type=" + type + ", bx_shift=" + bx_shift
				+ ", by_shift=" + by_shift + ", bh=" + bh + ", H=" + h + ", bc="
				+ bc + ", equip_id=" + equip_id + "]";
	}

	@Override
	public String toStringShow() {
		return toString();
	}

	public Long getEquip_id() {
		return equip_id;
	}

	public void setEquip_id(Long equip_id) {
		this.equip_id = equip_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBx_shift() {
		return bx_shift;
	}

	public void setBx_shift(double bx_shift) {
		this.bx_shift = bx_shift;
	}

	public double getBy_shift() {
		return by_shift;
	}

	public void setBy_shift(double by_shift) {
		this.by_shift = by_shift;
	}

	public double getBh() {
		return bh;
	}

	public void setBh(double bh) {
		this.bh = bh;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getBc() {
		return bc;
	}

	public void setBc(double bc) {
		this.bc = bc;
	}
}
