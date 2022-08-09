package ru.itm.bkdb.entity.tables.shift;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shifts", schema = "shift")
public final class Shift extends AbstractEntity {
	private String description;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "start_time")
	private Date start_time;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "end_time")
	private Date end_time;
	
	@Column(name = "threshold")
	private Integer threshold;

	public Shift(){}

	@Override
	public String toString() {
		return "shift.shifts{" +
				"id=" + id +
				", description=" + description +
				", start_time=" + start_time +
				", end_time=" + end_time +
				", thresold=" + threshold +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}
}
