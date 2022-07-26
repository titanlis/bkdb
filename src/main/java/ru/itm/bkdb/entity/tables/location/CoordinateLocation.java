package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coord_loc", schema = "location")
public final class CoordinateLocation extends AbstractEntity {

	@Column(name = "loc_id")
	private Long locId;
	
	@Column(name = "coord_loc_id")
	private Long coordLocId;
	
	private Float x;
	
	private Float y;
	
	private Float z;
	
	private Float radius;	
	

	public CoordinateLocation() {}
}
