package ru.itm.bkdb.entity.tables.equipment;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "equipment", schema = "equipment")
public class Equipment extends AbstractEntity {

	private String equip;
	private Long equip_type_id;
	private String description;
	private Integer model_id;
	private Integer fleet_id;
	private String mt_sn;
	private String mt_ip;
	private String mt_mac;
	private Float fuel;
	private String gnss;
	private Integer tires;
	private Integer cost_center_id;
	private Boolean active;

	public Equipment() {

	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", equipmentName=" + equip + ", equipmentTypeId=" + equip_type_id
				+ ", description=" + description + ", model=" + model_id + ", fleet=" + fleet_id + ", equipmentSerialNumber="
				+ mt_sn + ", equipmentIP=" + mt_ip + ", equipmentMAC=" + mt_mac
				+ ", fuelLevel=" + fuel + ", gnss=" + gnss + ", tires=" + tires + ", costCenter=" + cost_center_id
				+ ", active=" + active + "]";
	}


	@Override
	public String toStringShow() {
		return toString();
	}


	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	public Long getEquip_type_id() {
		return equip_type_id;
	}

	public void setEquip_type_id(Long equip_type_id) {
		this.equip_type_id = equip_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	public Integer getFleet_id() {
		return fleet_id;
	}

	public void setFleet_id(Integer fleet_id) {
		this.fleet_id = fleet_id;
	}

	public String getMt_sn() {
		return mt_sn;
	}

	public void setMt_sn(String mt_sn) {
		this.mt_sn = mt_sn;
	}

	public String getMt_ip() {
		return mt_ip;
	}

	public void setMt_ip(String mt_ip) {
		this.mt_ip = mt_ip;
	}

	public String getMt_mac() {
		return mt_mac;
	}

	public void setMt_mac(String mt_mac) {
		this.mt_mac = mt_mac;
	}

	public Float getFuel() {
		return fuel;
	}

	public void setFuel(Float fuel) {
		this.fuel = fuel;
	}

	public String getGnss() {
		return gnss;
	}

	public void setGnss(String gnss) {
		this.gnss = gnss;
	}

	public Integer getTires() {
		return tires;
	}

	public void setTires(Integer tires) {
		this.tires = tires;
	}

	public Integer getCost_center_id() {
		return cost_center_id;
	}

	public void setCost_center_id(Integer cost_center_id) {
		this.cost_center_id = cost_center_id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}



}
