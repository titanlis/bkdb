package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "equipment", schema = "equipment")
public class Equipment extends AbstractEntity {

	@Column(name = "equip")
	private String equipmentName;
			
	@Column(name = "equip_type_id")
	private int equipmentTypeId;
	
	@Column(name = "description_eq")
	private String description;
	
	@Column(name = "model_id")
	private Integer model;
	
	@Column(name = "fleet_id")
	private Integer fleet;
	
	@Column(name = "mt_sn")
	private String equipmentSerialNumber;
	
	@Column(name = "mt_ip")
	private String equipmentIP;
	
	@Column(name = "mt_mac")
	private String equipmentMAC;
	
	@Column(name = "fuel")
	private Float fuelLevel;
	
	private String gnss;

	private Integer tires;
	
	@Column(name = "cost_center_id")
	private Integer costCenter;
	
	private Boolean active;

	public Equipment() {

	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", equipmentName=" + equipmentName + ", equipmentTypeId=" + equipmentTypeId
				+ ", description=" + description + ", model=" + model + ", fleet=" + fleet + ", equipmentSerialNumber="
				+ equipmentSerialNumber + ", equipmentIP=" + equipmentIP + ", equipmentMAC=" + equipmentMAC
				+ ", fuelLevel=" + fuelLevel + ", gnss=" + gnss + ", tires=" + tires + ", costCenter=" + costCenter
				+ ", active=" + active + "]";
	}


}
