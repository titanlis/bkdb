package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "speed_limits", schema = "location")
public final class SpeedLimits extends AbstractEntity {
	private Long loc_id;
	private Long model_id;
	private Double low;
	private Double high;
	private Double norma;

	public SpeedLimits(){}

	@Override
	public String toString() {
		return "location.speed_limits{" +
				"id=" + id +
				", loc_id=" + loc_id +
				", model_id=" + model_id +
				", low=" + low +
				", high=" + high +
				", norma=" + norma +
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

	public Long getModel_id() {
		return model_id;
	}

	public void setModel_id(Long model_id) {
		this.model_id = model_id;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getNorma() {
		return norma;
	}

	public void setNorma(Double norma) {
		this.norma = norma;
	}
}
