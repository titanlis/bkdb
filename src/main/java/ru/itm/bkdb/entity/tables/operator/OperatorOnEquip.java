package ru.itm.bkdb.entity.tables.operator;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operator_on_equip", schema = "operator")
public final class OperatorOnEquip extends AbstractEntity {
	private Long operator_id;
	private Long equip_id;

	public OperatorOnEquip(){}

	@Override
	public String toString() {
		return "operator.operator_on_equip{" +
				"id=" + id +
				", operator_id=" + operator_id +
				", equip_id=" + equip_id +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(Long operator_id) {
		this.operator_id = operator_id;
	}

	public Long getEquip_id() {
		return equip_id;
	}

	public void setEquip_id(Long equip_id) {
		this.equip_id = equip_id;
	}
}
