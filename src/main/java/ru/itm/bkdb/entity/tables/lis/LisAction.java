package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "lis_action", schema = "lis")
public class LisAction extends AbstractEntity {

	private String name;
	private String description;

	public LisAction(){}

	public String toStringShow() {
		return "lis.lis_action [id=" + id + ", name=" + name + ", text=" + description + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
