package ru.itm.bkdb.entity.tables.config;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "values_data", schema = "config")
public class ValuesData extends AbstractEntity {
	@Column(name="name")
	private String name;
	@Column(name="value_data")
	private String value_data;
	@Column(name="descr")
	private String descr;


	@Override
	public String toStringShow(){
		return "[id=" + id + ", name =\'" + name + "\', value=\'" + value_data +"\', descr=\'"+ descr +"\']";
	}
	public ValuesData(){}

	public ValuesData(String name, String value_data, String descr) {
		this.name = name;
		this.value_data = value_data;
		this.descr = descr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue_data() {
		return value_data;
	}

	public void setValue_data(String value_data) {
		this.value_data = value_data;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}