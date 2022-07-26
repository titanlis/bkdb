package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_source_varible", schema = "lis")
public class LisActionSourceVariable extends AbstractEntity {

	@Column(name = "lis_source_varible_FK")
	private int lisSourceVariableFK;
	
	@Column(name = "lis_action_variable_connect_FK")
	private int lisActionVariableConnectFK;
	
	@Column(name = "lis_action_variable_choosed_FK")
	private int lisActionVariableChoosedFK;
	
	
	public LisActionSourceVariable() {
	}
}
