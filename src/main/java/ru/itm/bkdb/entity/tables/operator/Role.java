package ru.itm.bkdb.entity.tables.operator;


import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "operator")
public final class Role extends AbstractEntity {
	private String name;
	private String descr;
	private boolean active;

	public Role(){}

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
		return "[id=" + id + ", name =\'" + name + "\', descr=\'" + descr +", active=\'"+ active +"\']";
	}
}
