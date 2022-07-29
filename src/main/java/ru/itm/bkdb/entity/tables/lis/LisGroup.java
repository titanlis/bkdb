package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_group", schema = "lis")
public class LisGroup extends AbstractEntity {
	private String name;

	public LisGroup(){}

	@Override
	public String toStringShow() {
		return null;
	}
}
