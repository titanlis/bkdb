package ru.itm.bkdb.entity.tables.act;


import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acts_to_roles", schema = "operator")
public class ActToRole extends AbstractEntity {
	private Long act_id;
	private Long role_id;

	public ActToRole(){}

}
