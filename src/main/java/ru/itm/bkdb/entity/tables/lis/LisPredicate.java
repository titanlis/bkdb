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
	
	@Column(name = "func", columnDefinition = "text")	
	private String function;	

	public LisPredicate(){}
}
