package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location_auto_status", schema = "location")
public final class LocationAutoStatus extends AbstractEntity {

	private Long status_cat_id_1;
	private Long status_cat_id_2;
	private Long status_cat_id_3;
	private String start_time;
	private String end_time;

	public LocationAutoStatus(){}

	@Override
	public String toString() {
		return "location.location_auto_status{" +
				"id=" + id +
				", status_cat_id_1=" + status_cat_id_1 +
				", status_cat_id_2=" + status_cat_id_2 +
				", status_cat_id_3=" + status_cat_id_3 +
				", start_time=" + start_time +
				", end_time=" + end_time +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getStatus_cat_id_1() {
		return status_cat_id_1;
	}

	public void setStatus_cat_id_1(Long status_cat_id_1) {
		this.status_cat_id_1 = status_cat_id_1;
	}

	public Long getStatus_cat_id_2() {
		return status_cat_id_2;
	}

	public void setStatus_cat_id_2(Long status_cat_id_2) {
		this.status_cat_id_2 = status_cat_id_2;
	}

	public Long getStatus_cat_id_3() {
		return status_cat_id_3;
	}

	public void setStatus_cat_id_3(Long status_cat_id_3) {
		this.status_cat_id_3 = status_cat_id_3;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
}
