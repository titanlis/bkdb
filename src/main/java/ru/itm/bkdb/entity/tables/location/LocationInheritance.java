package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "loc_inheritance", schema = "location")
public final class LocationInheritance extends AbstractEntity {
	private Long parent_loc_id;
	private Long child_loc_id;

	public LocationInheritance(){}

	@Override
	public String toString() {
		return "location.loc_inheritance{" +
				"id=" + id +
				", parent_loc_id=" + parent_loc_id +
				", child_loc_id=" + child_loc_id +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getParent_loc_id() {
		return parent_loc_id;
	}

	public void setParent_loc_id(Long parent_loc_id) {
		this.parent_loc_id = parent_loc_id;
	}

	public Long getChild_loc_id() {
		return child_loc_id;
	}

	public void setChild_loc_id(Long child_loc_id) {
		this.child_loc_id = child_loc_id;
	}
}
