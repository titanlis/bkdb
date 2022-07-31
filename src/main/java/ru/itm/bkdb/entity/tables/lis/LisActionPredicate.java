package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_predicate", schema = "lis")
public class LisActionPredicate extends AbstractEntity {

	private boolean precond_result;
	private Long lis_action_FK;
	private Long lis_predicate_FK;

	public LisActionPredicate() {
	}

	@Override
	public String toStringShow() {
		return "LisActionPredicate [id=" + id + ", precond_result=" + precond_result
				+ ", lis_action_FK=" + lis_action_FK
				+ ", lis_predicate_FK=" + lis_predicate_FK + "]";
	}

	public boolean isPrecond_result() {
		return precond_result;
	}

	public void setPrecond_result(boolean precond_result) {
		this.precond_result = precond_result;
	}

	public Long getLis_action_FK() {
		return lis_action_FK;
	}

	public void setLis_action_FK(Long lis_action_FK) {
		this.lis_action_FK = lis_action_FK;
	}

	public Long getLis_predicate_FK() {
		return lis_predicate_FK;
	}

	public void setLis_predicate_FK(Long lis_predicate_FK) {
		this.lis_predicate_FK = lis_predicate_FK;
	}
}
