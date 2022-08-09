package ru.itm.bkdb.entity.tables.operator;


import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acts_to_roles", schema = "operator")
public class ActToRole extends AbstractEntity {
	private Long act_id;
	private Long role_id;

	public ActToRole(){}

	public ActToRole(Long act_id, Long role_id) {
		this.act_id = act_id;
		this.role_id = role_id;
	}

	public Long getAct_id() {
		return act_id;
	}

	public void setAct_id(Long act_id) {
		this.act_id = act_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toStringShow(){
		return "operator.acts_to_roles [id=" + id + ", act_id =\'" + act_id + "\', role_id=\'" + role_id +"]" ;
	}
}
