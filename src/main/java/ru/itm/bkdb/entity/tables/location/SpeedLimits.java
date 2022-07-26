package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "speed_limits", schema = "location")
public final class SpeedLimits extends AbstractEntity {

	@Column(name = "loc_id")
	private Long locId;
	
	@Column(name = "model_id")
	private Long modelId;
	
	private Double low;
	private Double high;
	private Double norma;

	public SpeedLimits(){}

}
