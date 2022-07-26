package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "trans_status", schema = "trans")
public class TransStatus extends AbstractEntity {
	@Column(name = "status_id_1")
	private Long statusIdOne;

	@Column(name = "status_id_2")
	private Long statusIdTwo;

	@Column(name = "status_id_3")
	private Long statusIdThree;

	@Column(name = "equip_id")
	private Long equipId;

	@Column(name = "start_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDt;

	@Column(name = "end_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDt;

	@Column(name = "duration")
	private Double duration;

	@Column(name = "cost_center_id")
	private Long costCenterId;

	@Column(name = "source_set")
	private String sourceSet;
	
	public TransStatus() {}

}
