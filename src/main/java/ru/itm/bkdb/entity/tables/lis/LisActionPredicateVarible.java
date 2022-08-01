package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_predicate_varible", schema = "lis")
public class LisActionPredicateVarible extends AbstractEntity {
	private int lis_predicate_varible_FK;
	private int lis_action_varible_FK;

	public LisActionPredicateVarible() {
	}

	@Override
	public String toStringShow() {
		return "LisActionPredicateVariable [id=" + id + ", lis_predicate_varible_FK=" + lis_predicate_varible_FK
				+ ", lis_action_varible_FK=" + lis_action_varible_FK
				+ "]";
	}

	public int getLis_predicate_varible_FK() {
		return lis_predicate_varible_FK;
	}

	public void setLis_predicate_varible_FK(int lis_predicate_varible_FK) {
		this.lis_predicate_varible_FK = lis_predicate_varible_FK;
	}

	public int getLis_action_varible_FK() {
		return lis_action_varible_FK;
	}

	public void setLis_action_varible_FK(int lis_action_varible_FK) {
		this.lis_action_varible_FK = lis_action_varible_FK;
	}
}
