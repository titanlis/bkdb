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
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "end_time")
	private Date endTime;
	
	@Column(name = "thresold")
	private Integer threshold;

	public Shift(){}
}
