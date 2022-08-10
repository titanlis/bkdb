package ru.itm.bkdb.entity.tables.tire;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tire_assign", schema = "tire")
public final class TireAssign extends AbstractEntity {
	private Long tire_id;
	private Long equip_id;
	private Long tire_storage_id;
	private Integer position;
	private String time_assign;
	private Long sensor_id;

	@Override
	public String toString() {
		return "tire.tire_assign{" +
				"id=" + id +
				", tire_id=" + tire_id +
				", equip_id=" + equip_id +
				", tire_storage_id=" + tire_storage_id +
				", position=" + position +
				", time_assign=" + time_assign +
				", sensor_id=" + sensor_id +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getTire_id() {
		return tire_id;
	}

	public void setTire_id(Long tire_id) {
		this.tire_id = tire_id;
	}

	public Long getEquip_id() {
		return equip_id;
	}

	public void setEquip_id(Long equip_id) {
		this.equip_id = equip_id;
	}

	public Long getTire_storage_id() {
		return tire_storage_id;
	}

	public void setTire_storage_id(Long tire_storage_id) {
		this.tire_storage_id = tire_storage_id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getTime_assign() {
		return time_assign;
	}

	public void setTime_assign(String time_assign) {
		this.time_assign = time_assign;
	}

	public Long getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(Long sensor_id) {
		this.sensor_id = sensor_id;
	}
}
