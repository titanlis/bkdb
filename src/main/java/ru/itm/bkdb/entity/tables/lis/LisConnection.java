package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_connection", schema = "lis")
public class LisConnection extends AbstractEntity {

	@Column(name = "predicate_FK")
	private Long predicate_fk;
	
	@Column(name = "action_result_FK")
	private Long action_result_fk;
	
	@Column(name = "action_precond_FK")
	private Long action_precond_fk;
	
	
	public LisConnection() {
	}

	@Override
	public String toString() {
		return "LisConnection{" +
				"id=" + id +
				", predicate_fk=" + predicate_fk +
				", action_result_fk=" + action_result_fk +
				", action_precond_fk=" + action_precond_fk +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getPredicate_fk() {
		return predicate_fk;
	}

	public void setPredicate_fk(Long predicate_fk) {
		this.predicate_fk = predicate_fk;
	}

	public Long getAction_result_fk() {
		return action_result_fk;
	}

	public void setAction_result_fk(Long action_result_fk) {
		this.action_result_fk = action_result_fk;
	}

	public Long getAction_precond_fk() {
		return action_precond_fk;
	}

	public void setAction_precond_fk(Long action_precond_fk) {
		this.action_precond_fk = action_precond_fk;
	}
}
