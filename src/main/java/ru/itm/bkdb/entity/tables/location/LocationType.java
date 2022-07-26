package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location_type", schema = "location")
public final class LocationType extends AbstractEntity {
	private String name;
	private String description;
	
	@Column(name = "status_return")
	private boolean statusReturn;
	
	@Column(name = "location_color")
	private String locationColor;

	public LocationType(){}
}
