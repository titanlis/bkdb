package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_action_varible", schema = "lis")
public class LisActionVariable extends AbstractEntity {
	private String name;
	private String description;
	
	@Column(name = "type")
	private Integer typeFK;	
	
	@Column(name = "default_value")
	private String defaultValue;
	
	@Column(name = "lis_action_FK", nullable = false)
	private Integer lisActionFK;
	
	//ссылка на ФК соурса
	@Column(name = "action_varible_source_FK", nullable = true)
	private Integer actionVariableSourceFk;	

	public LisActionVariable(){}

	@Override
	public String toStringShow() {
		return null;
	}
}
