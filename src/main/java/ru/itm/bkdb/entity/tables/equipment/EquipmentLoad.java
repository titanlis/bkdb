package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_load", schema = "equipment")
public class EquipmentLoad  extends AbstractEntity {
	private Long equip_id;
	private float radius_load;
	private float radius_wait;
	private Float radius_bucket;

	public EquipmentLoad() {
	}

	@Override
	public String toStringShow() {
		return "Equipment [id=" + id + ", radius_load=" + radius_load + ", radius_wait=" + radius_wait
				+ ", radius_bucket=" + radius_bucket + ", equip_id=" + equip_id + "]";
	}

	public Long getEquip_id() {
		return equip_id;
	}

	public void setEquip_id(Long equip_id) {
		this.equip_id = equip_id;
	}

	public float getRadius_load() {
		return radius_load;
	}

	public void setRadius_load(float radius_load) {
		this.radius_load = radius_load;
	}

	public float getRadius_wait() {
		return radius_wait;
	}

	public void setRadius_wait(float radius_wait) {
		this.radius_wait = radius_wait;
	}

	public Float getRadius_bucket() {
		return radius_bucket;
	}

	public void setRadius_bucket(Float radius_bucket) {
		this.radius_bucket = radius_bucket;
	}
}