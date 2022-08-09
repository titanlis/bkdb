package ru.itm.bkdb.entity.tables.operator;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operator_on_equip_type", schema = "operator")
public final class OperatorOnEquipType extends AbstractEntity {
	private Long operator_id;
	private Long equip_type_id;

	@Override
	public String toString() {
		return "operator.operator_on_equip_type{" +
				"id=" + id +
				", operator_id=" + operator_id +
				", equip_type_id=" + equip_type_id +
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

	public Long getEquip_type_id() {
		return equip_type_id;
	}

	public void setEquip_type_id(Long equip_type_id) {
		this.equip_type_id = equip_type_id;
	}
}
