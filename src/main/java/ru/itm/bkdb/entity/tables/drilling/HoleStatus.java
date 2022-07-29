package ru.itm.bkdb.entity.tables.drilling;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hole_status", schema = "drilling")
public class HoleStatus extends AbstractEntity {
	private String name;
	private String descr;
	private String color;

	public String toStringShow(){
		return "[id=" + id + ", name=\'" + name +"\', descr=\'" + descr + "\', color=\'" + color + "\']" ;
	}

	public HoleStatus() {}

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
