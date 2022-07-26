package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location_auto_status", schema = "location")
public final class LocationAutoStatus extends AbstractEntity {

	@Column(name = "status_cat_id_1")
	private Long statusCatId1;
	
	@Column(name = "status_cat_id_2")
	private Long statusCatId2;
	
	@Column(name = "status_cat_id_3")
	private Long statusCatId3;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	
	public LocationAutoStatus(){}
}
