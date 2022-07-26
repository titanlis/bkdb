package ru.itm.bkdb.entity.tables.operator;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operator_on_equip", schema = "operator")
public final class OperatorOnEquip extends AbstractEntity {
	@Column(name = "operator_id")
	private Long operatorId;
	
	@Column(name = "equip_id")
	private Long equipId;

	public OperatorOnEquip(){}
}
