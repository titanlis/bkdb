package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roads", schema = "location")
public class Road extends AbstractEntity {
	private Long loc_id;
	private Float timing;
	private Float lengths;
	private Float lvl;
	private Float angle;
	private boolean active;

	public Road(){}

	@Override
	public String toString() {
		return "location.roads{" +
				"id=" + id +
				", loc_id=" + loc_id +
				", timing=" + timing +
				", lengths=" + lengths +
				", lvl=" + lvl +
				", angle=" + angle +
				", active=" + active +
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

	public Float getTiming() {
		return timing;
	}

	public void setTiming(Float timing) {
		this.timing = timing;
	}

	public Float getLengths() {
		return lengths;
	}

	public void setLengths(Float lengths) {
		this.lengths = lengths;
	}

	public Float getLvl() {
		return lvl;
	}

	public void setLvl(Float lvl) {
		this.lvl = lvl;
	}

	public Float getAngle() {
		return angle;
	}

	public void setAngle(Float angle) {
		this.angle = angle;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
