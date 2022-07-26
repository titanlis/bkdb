package ru.itm.bkdb.entity.tables.tire;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tires", schema = "tire")
public class Tire extends AbstractEntity {
	private String sn;
	private Double maxtemp;
	private Double mintemp;
	private Double maxpress;
	private Double minpress;
	private Double tkph;
	private String size;

	@Column(name = "install_date")
	private String installDate;

	@Column(name = "manuf_date")
	private String manufDate;

	private String manufacturer;

	public Tire() {}

}
