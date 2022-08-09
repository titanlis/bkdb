package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status_group", schema = "status")
public final class StatusGroup extends AbstractEntity {
	private String name;
	private String descr;
	public StatusGroup(){}

	@Override
	public String toString() {
		return "status.status_group{" +
				"id=" + id +
				", name=" + name +
				", descr=" + descr +
				'}';
	}
	@Override
	public String toStringShow() {
		return this.toString();
	}

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
}
