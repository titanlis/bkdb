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
	private Long location_type_id;
	private Integer threshold_time;
	private Integer stop_threshold;
	private Long loc_material_id;
	private Long loc_material2_id;
	private boolean active;
	private Integer type_polygon;
	private Float height;

	public Location(){}

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

	public Long getLocation_type_id() {
		return location_type_id;
	}

	public void setLocation_type_id(Long location_type_id) {
		this.location_type_id = location_type_id;
	}

	public Integer getThreshold_time() {
		return threshold_time;
	}

	public void setThreshold_time(Integer threshold_time) {
		this.threshold_time = threshold_time;
	}

	public Integer getStop_threshold() {
		return stop_threshold;
	}

	public void setStop_threshold(Integer stop_threshold) {
		this.stop_threshold = stop_threshold;
	}

	public Long getLoc_material_id() {
		return loc_material_id;
	}

	public void setLoc_material_id(Long loc_material_id) {
		this.loc_material_id = loc_material_id;
	}

	public Long getLoc_material2_id() {
		return loc_material2_id;
	}

	public void setLoc_material2_id(Long loc_material2_id) {
		this.loc_material2_id = loc_material2_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getType_polygon() {
		return type_polygon;
	}

	public void setType_polygon(Integer type_polygon) {
		this.type_polygon = type_polygon;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	@Override
	public String toStringShow(){
		return "[id=" + id + ", name=\'" + name +"\', description=\'" + description + "\' ....]" ;
	}

}
