package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_source_variable", schema = "lis")
public class LisSourceVariable extends AbstractEntity {

	@Column(name = "number_var")
	private int number;
	
	@Column(name = "type")
	private Integer typeFK;
	
	@Column(name = "lis_source_FK")
	private int lisSourceId;	
	
	public LisSourceVariable(){}

	@Override
	public String toStringShow() {
		return null;
	}
}
