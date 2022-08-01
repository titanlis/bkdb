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
	private Integer type;
	private String default_value;
	@Column(name = "lis_action_FK", nullable = false)
	private Integer lis_action_fk;
	
	//ссылка на ФК соурса
	@Column(name = "action_varible_source_FK", nullable = true)
	private Integer action_varible_source_fk;

	public LisActionVariable(){}

	@Override
	public String toString() {
		return "LisSourceVariable{" +
				"id=" + id +
				", name=" + name +
				", description=" + description +
				", type=" + type +
				", default_value=" + default_value +
				", lis_action_fk=" + lis_action_fk +
				", action_varible_source_fk=" + action_varible_source_fk +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDefault_value() {
		return default_value;
	}

	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}

	public Integer getLis_action_fk() {
		return lis_action_fk;
	}

	public void setLis_action_fk(Integer lis_action_fk) {
		this.lis_action_fk = lis_action_fk;
	}

	public Integer getAction_varible_source_fk() {
		return action_varible_source_fk;
	}

	public void setAction_varible_source_fk(Integer action_varible_source_fk) {
		this.action_varible_source_fk = action_varible_source_fk;
	}
}
