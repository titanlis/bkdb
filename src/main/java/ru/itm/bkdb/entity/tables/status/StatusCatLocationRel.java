package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status_cat_location_rel", schema = "status")
public final class StatusCatLocationRel extends AbstractEntity {
	private Long location_auto_status_id;
	private Long location_type_id;
	private Boolean on_enter;
	private Boolean on_exit;

	public StatusCatLocationRel() {}

	@Override
	public String toString() {
		return "status.status_cat_location_rel{" +
				"id=" + id +
				", location_auto_status_id=" + location_auto_status_id +
				", location_type_id=" + location_type_id +
				", on_enter=" + on_enter +
				", on_exit=" + on_exit +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getLocation_auto_status_id() {
		return location_auto_status_id;
	}

	public void setLocation_auto_status_id(Long location_auto_status_id) {
		this.location_auto_status_id = location_auto_status_id;
	}

	public Long getLocation_type_id() {
		return location_type_id;
	}

	public void setLocation_type_id(Long location_type_id) {
		this.location_type_id = location_type_id;
	}

	public Boolean getOn_enter() {
		return on_enter;
	}

	public void setOn_enter(Boolean on_enter) {
		this.on_enter = on_enter;
	}

	public Boolean getOn_exit() {
		return on_exit;
	}

	public void setOn_exit(Boolean on_exit) {
		this.on_exit = on_exit;
	}
}
