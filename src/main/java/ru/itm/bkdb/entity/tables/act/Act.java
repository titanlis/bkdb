package ru.itm.bkdb.entity.tables.act;


import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acts", schema = "operator")
public class Act extends AbstractEntity {

	private String name;
	private String descr;
	private boolean active;

	public Act(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String toStringShow(){
		return "[id=" + id + ", name=\'" + name + "\', descr=\'" + descr + "\', active=" + active+"]" ;
	}


}
