package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location", schema = "location")
public class Location extends AbstractEntity {

	private String name;
	private String description;
	
	@Column(name = "location_type_id")
	private Long locationTypeId;
	
	@Column(name = "threshold_time")
	private Integer thresholdTime;
	
	@Column(name = "stop_threshold")
	private Integer stopThreshold;
	
	@Column(name = "loc_material_id")
	private Long locMaterialId;
	
	@Column(name = "loc_material2_id")
	private Long locMaterial2Id;
	
	private boolean active;
	
	@Column(name = "type_polygon")
	private Integer typePolygon;
	
	private Float height;

	
	public Location(){}
}
