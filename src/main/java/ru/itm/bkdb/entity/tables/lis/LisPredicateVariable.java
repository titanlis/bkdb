package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_predicate_varible", schema = "lis")
public class LisPredicateVariable extends AbstractEntity {

	@Column(name = "number_var")
	private int number;
	
	@Column(name = "type")
	private Integer typeFK;
	
	@Column(name = "lis_predicate_FK")
	private int lisPredicateId;	
	
	public LisPredicateVariable(){}
}
