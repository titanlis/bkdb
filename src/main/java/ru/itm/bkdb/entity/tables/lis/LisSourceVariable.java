package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_source_variable", schema = "lis")
public class LisSourceVariable extends AbstractEntity {

	private int number_var;
	private Integer type;
	private int lis_source_fk;

	@Override
	public String toStringShow() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "LisSourceVariable{" +
				"id=" + id +
				", number_var=" + number_var +
				", type=" + type +
				", lis_source_fk=" + lis_source_fk +
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

	public int getLis_source_fk() {
		return lis_source_fk;
	}

	public void setLis_source_fk(int lis_source_fk) {
		this.lis_source_fk = lis_source_fk;
	}
}
