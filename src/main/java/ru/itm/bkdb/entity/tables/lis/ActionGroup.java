package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "action_group", schema = "lis")
public class ActionGroup  extends AbstractEntity {
	private Long lis_action_FK;
	private Long lis_group_FK;
	private Boolean isdrawn;
	private Double x;
	private Double y;

	public ActionGroup() {
	}

	@Override
	public String toStringShow() {
		return "ActionGroup [id=" + id + ", lis_action_FK=" + lis_action_FK + ", lis_group_FK=" + lis_group_FK
				+ ", isdrawn=" + isdrawn + ", x=" + x + ", y=" + y + "]";
	}

	public Long getLis_action_FK() {
		return lis_action_FK;
	}

	public void setLis_action_FK(Long lis_action_FK) {
		this.lis_action_FK = lis_action_FK;
	}

	public Long getLis_group_FK() {
		return lis_group_FK;
	}

	public void setLis_group_FK(Long lis_group_FK) {
		this.lis_group_FK = lis_group_FK;
	}

	public Boolean getIsdrawn() {
		return isdrawn;
	}

	public void setIsdrawn(Boolean isdrawn) {
		this.isdrawn = isdrawn;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
}
