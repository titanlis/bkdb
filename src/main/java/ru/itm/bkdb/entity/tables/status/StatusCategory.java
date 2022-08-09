package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status_cat", schema = "status")
public final class StatusCategory extends AbstractEntity {
	private Long status_id;
	private Long equip_type_id;
	private Long equip_id;
	private Integer substatus;
	private String color;
	private Float speed;
	private Integer next_status;
	private boolean active;
	private String pic;

	public StatusCategory(){}

	@Override
	public String toString() {
		return "status.status_cat{" +
				"id=" + id +
				", status_id=" + status_id +
				", equip_id=" + equip_id +
				", substatus=" + substatus +
				", color=" + color +
				", speed=" + speed +
				", next_status=" + next_status +
				", active=" + active +
				", pic=" + pic +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public Long getEquip_type_id() {
		return equip_type_id;
	}

	public void setEquip_type_id(Long equip_type_id) {
		this.equip_type_id = equip_type_id;
	}

	public Long getEquip_id() {
		return equip_id;
	}

	public void setEquip_id(Long equip_id) {
		this.equip_id = equip_id;
	}

	public Integer getSubstatus() {
		return substatus;
	}

	public void setSubstatus(Integer substatus) {
		this.substatus = substatus;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Integer getNext_status() {
		return next_status;
	}

	public void setNext_status(Integer next_status) {
		this.next_status = next_status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}
