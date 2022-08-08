package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coord_loc", schema = "location")
public final class CoordinateLocation extends AbstractEntity {
	private Long loc_id;
	private Long coord_loc_id;
	private Float x;
	private Float y;
	private Float z;
	private Float radius;

	public CoordinateLocation() {}

	@Override
	public String toString() {
		return "location.coord_loc{" +
				"id=" + id +
				", loc_id=" + loc_id +
				", coord_loc_id=" + coord_loc_id +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", radius=" + radius +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(Long loc_id) {
		this.loc_id = loc_id;
	}

	public Long getCoord_loc_id() {
		return coord_loc_id;
	}

	public void setCoord_loc_id(Long coord_loc_id) {
		this.coord_loc_id = coord_loc_id;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Float getZ() {
		return z;
	}

	public void setZ(Float z) {
		this.z = z;
	}

	public Float getRadius() {
		return radius;
	}

	public void setRadius(Float radius) {
		this.radius = radius;
	}
}
