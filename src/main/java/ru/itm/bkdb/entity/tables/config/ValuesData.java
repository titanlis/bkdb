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
	private String valueData;
	@Column(name="descr")
	private String descr;


	public String toStringShow(){
		return "[id=" + id + ", name =\'" + name + "\', value=\'" + valueData +"\', descr=\'"+ descr +"\']";
	}
	public ValuesData(){}

	public ValuesData(String name, String valueData, String descr) {
		this.name = name;
		this.valueData = valueData;
		this.descr = descr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueData() {
		return valueData;
	}

	public void setValueData(String valueData) {
		this.valueData = valueData;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}