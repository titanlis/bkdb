package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "action_varible_source", schema = "lis")
public class ActionVariableSource extends AbstractEntity {

	private String name;
	
	@Column(name = "type")	
	private Long typeId;
	
	public ActionVariableSource(){}

	@Override
	public String toStringShow() {
		return null;
	}
}
