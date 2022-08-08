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
	private boolean status_return;
	private String location_color;

	public LocationType(){}

	@Override
	public String toString() {
		return "location.location_type{" +
				"id=" + id +
				", name=" + name +
				", description=" + description +
				", status_return=" + status_return +
				", location_color=" + location_color +
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

	public boolean isStatus_return() {
		return status_return;
	}

	public void setStatus_return(boolean status_return) {
		this.status_return = status_return;
	}

	public String getLocation_color() {
		return location_color;
	}

	public void setLocation_color(String location_color) {
		this.location_color = location_color;
	}
}
