package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_predicate", schema = "lis")
public class LisPredicate extends AbstractEntity {
	private String name;
	private String description;
	private String type;
	
	//@Column(name = "func", columnDefinition = "text")
	private String func;

	public LisPredicate(){}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "LisPredicate{" +
				"id=" + id +
				", name=" + name +
				", description=" + description +
				", type=" + type +
				", func=" + func +
				'}';
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}
}
