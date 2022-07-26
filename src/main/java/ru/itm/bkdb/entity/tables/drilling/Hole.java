package ru.itm.bkdb.entity.tables.drilling;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "holes", schema = "drilling")
public class Hole extends AbstractEntity {
	@Column(name = "id_loc")
	private Long idLoc;
	private Integer number;
	
	@Column(name = "drilling_z")
	private Double drillingZ;
	
	private Double azimuth;
	
	@Column(name = "drill_angle")
	private Double drillAngle;
	
	@Column(name = "after_deep")
	private Double afterDeep;
	
	private String description;

	public Hole(){}
}
