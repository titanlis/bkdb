package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_predicate_variable", schema = "lis")
public class LisPredicateVariable extends AbstractEntity {

	@Column(name = "number_var")
	private int number_var;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "lis_predicate_FK")
	private int lis_predicate_fk;
	
	public LisPredicateVariable(){}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "LisPredicateVariable{" +
				"id=" + id +
				", number_var=" + number_var +
				", type=" + type +
				", lis_predicate_fk=" + lis_predicate_fk +
				'}';
	}

	public int getNumber_var() {
		return number_var;
	}

	public void setNumber_var(int number_var) {
		this.number_var = number_var;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getLis_predicate_fk() {
		return lis_predicate_fk;
	}

	public void setLis_predicate_fk(int lis_predicate_fk) {
		this.lis_predicate_fk = lis_predicate_fk;
	}
}
