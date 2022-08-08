package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_predicate_variable", schema = "lis")
public class LisActionPredicateVariable extends AbstractEntity {
	private int lis_predicate_variable_FK;
	private int lis_action_variable_FK;

	public LisActionPredicateVariable() {
	}

	@Override
	public String toStringShow() {
		return "LisActionPredicateVariable [id=" + id + ", lis_predicate_variable_FK=" + lis_predicate_variable_FK
				+ ", lis_action_variable_FK=" + lis_action_variable_FK
				+ "]";
	}

	public int getLis_predicate_variable_FK() {
		return lis_predicate_variable_FK;
	}

	public void setLis_predicate_variable_FK(int lis_predicate_variable_FK) {
		this.lis_predicate_variable_FK = lis_predicate_variable_FK;
	}

	public int getLis_action_variable_FK() {
		return lis_action_variable_FK;
	}

	public void setLis_action_variable_FK(int lis_action_variable_FK) {
		this.lis_action_variable_FK = lis_action_variable_FK;
	}
}
