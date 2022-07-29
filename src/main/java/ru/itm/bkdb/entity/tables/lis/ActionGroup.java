package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "action_group", schema = "lis")
public class ActionGroup  extends AbstractEntity {

	@Column(name = "lis_action_FK")	
	private Long lisActionId;

	@Column(name = "lis_group_FK")	
	private Long lisGroupId;

	@Column(name = "isdrawn")
	private Boolean isDrawn;

	private Double x;

	private Double y;

	public ActionGroup() {
	}

	@Override
	public String toStringShow() {
		return null;
	}
}
