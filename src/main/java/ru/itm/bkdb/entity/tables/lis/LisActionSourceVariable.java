package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_source_variable", schema = "lis")
public class LisActionSourceVariable extends AbstractEntity {
	private int lis_source_variable_fk;
	private int lis_action_variable_connect_fk;
	private int lis_action_variable_choosed_fk;

	public LisActionSourceVariable() {
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "LisActionSourceVariable{" +
				"id=" + id +
				", lis_source_variable_FK=" + lis_source_variable_fk +
				", lis_action_variable_connect_FK=" + lis_action_variable_connect_fk +
				", lis_action_variable_choosed_FK=" + lis_action_variable_choosed_fk +
				'}';
	}

	public int getLis_source_variable_fk() {
		return lis_source_variable_fk;
	}

	public void setLis_source_variable_fk(int lis_source_variable_fk) {
		this.lis_source_variable_fk = lis_source_variable_fk;
	}

	public int getLis_action_variable_connect_fk() {
		return lis_action_variable_connect_fk;
	}

	public void setLis_action_variable_connect_fk(int lis_action_variable_connect_fk) {
		this.lis_action_variable_connect_fk = lis_action_variable_connect_fk;
	}

	public int getLis_action_variable_choosed_fk() {
		return lis_action_variable_choosed_fk;
	}

	public void setLis_action_variable_choosed_fk(int lis_action_variable_choosed_fk) {
		this.lis_action_variable_choosed_fk = lis_action_variable_choosed_fk;
	}
}
