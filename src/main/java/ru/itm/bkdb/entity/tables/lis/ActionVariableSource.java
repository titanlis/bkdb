package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "action_variable_source", schema = "lis")
public class ActionVariableSource extends AbstractEntity {

	private String name;
	private Long type;

	public ActionVariableSource(){}

	@Override
	public String toStringShow() {
		return "ActionGroup [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
}
