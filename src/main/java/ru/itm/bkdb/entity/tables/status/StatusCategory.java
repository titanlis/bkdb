package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status_cat", schema = "status")
public final class StatusCategory extends AbstractEntity {

	@Column(name = "status_id")
	private Long statusId;
	
	@Column(name = "equip_type_id")
	private Long equipTypeId;
	
	@Column(name = "equip_id")
	private Long equipId;
	
	private Integer substatus;
	
	private String color;
	
	private Float speed;
	
	@Column(name = "next_status")
	private Integer nextStatus;
	
	private boolean active;
	private String pic;

	public StatusCategory(){}
}
