package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status_inh", schema = "status")
public final class StatusInheritance extends AbstractEntity {
	@Column(name = "cur_st_id")
	private Long curStId;
	
	@Column(name = "nxt_st_id")
	private Long nxtStId;
	
	private boolean excluded;
}
