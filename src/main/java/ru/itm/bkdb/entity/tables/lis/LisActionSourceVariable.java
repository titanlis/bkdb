package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_source_varible", schema = "lis")
public class LisActionSourceVariable extends AbstractEntity {
	private int lis_source_varible_FK;
	private int lis_action_variable_connect_FK;
	private int lis_action_variable_choosed_FK;

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
				", lis_source_varible_FK=" + lis_source_varible_FK +
				", lis_action_variable_connect_FK=" + lis_action_variable_connect_FK +
				", lis_action_variable_choosed_FK=" + lis_action_variable_choosed_FK +
				'}';
	}

	public int getLis_source_varible_FK() {
		return lis_source_varible_FK;
	}

	public void setLis_source_varible_FK(int lis_source_varible_FK) {
		this.lis_source_varible_FK = lis_source_varible_FK;
	}

	public int getLis_action_variable_connect_FK() {
		return lis_action_variable_connect_FK;
	}

	public void setLis_action_variable_connect_FK(int lis_action_variable_connect_FK) {
		this.lis_action_variable_connect_FK = lis_action_variable_connect_FK;
	}

	public int getLis_action_variable_choosed_FK() {
		return lis_action_variable_choosed_FK;
	}

	public void setLis_action_variable_choosed_FK(int lis_action_variable_choosed_FK) {
		this.lis_action_variable_choosed_FK = lis_action_variable_choosed_FK;
	}
}
