package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_haul", schema = "equipment")
public class EquipmentHaul extends AbstractEntity {
	private Long equip_id;
	private float volume;
	private float payload;
	private Float empty_weight;
	private String tire_type;

	public EquipmentHaul() {
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", empty_weight=" + empty_weight + ", tire_type=" + tire_type
				+ ", equip_id=" + equip_id + "]";
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

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getPayload() {
		return payload;
	}

	public void setPayload(float payload) {
		this.payload = payload;
	}

	public Float getEmpty_weight() {
		return empty_weight;
	}

	public void setEmpty_weight(Float empty_weight) {
		this.empty_weight = empty_weight;
	}

	public String getTire_type() {
		return tire_type;
	}

	public void setTire_type(String tire_type) {
		this.tire_type = tire_type;
	}
}
