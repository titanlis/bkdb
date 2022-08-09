package ru.itm.bkdb.entity.tables.operator;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operators", schema = "operator")
public class Operator extends AbstractEntity {
	private String tab;
	private String name;
	private String surname;
	private String middle;
	private String licence;
	private String expire;
	private Long role_id;
	private boolean active;
	private String rfid_id;

	public Operator() {}

	@Override
	public String toString() {
		return "operator.operators{" +
				"id=" + id +
				", tab=" + tab +
				", name=" + name +
				", surname=" + surname +
				", middle=" + middle +
				", licence=" + licence +
				", expire=" + expire +
				", role_id=" + role_id +
				", active=" + active +
				", rfid_id=" + rfid_id +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRfid_id() {
		return rfid_id;
	}

	public void setRfid_id(String rfid_id) {
		this.rfid_id = rfid_id;
	}
}
