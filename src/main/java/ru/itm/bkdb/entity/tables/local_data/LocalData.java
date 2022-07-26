package ru.itm.bkdb.entity.tables.local_data;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "local_data", schema = "current")
public class LocalData extends AbstractEntity {

	@Column(name = "career_loc_id")
	private Long careerLocId;
	
	@Column(name = "cur_z")
	private Long curZ;
	
	@Column(name = "subscribed_fuel_truck")
	private Long subscribedFueltruckId;
	
	@Column(name = "interaction_id")
	private Long interactionId;
	
	@Column(name = "load_loc_id")
	private Long loadLocId;
	
	@Column(name = "lu_id")
	private Long luId;
	
	@Column(name = "material_id")
	private Long materialId;
	
	@Column(name = "refuel_zone_id")
	private Long refuelZoneId;
	
	@Column(name = "shift_id")
	private Long shiftId;
	
	@Column(name = "unload_loc_id")
	private Long unloadLocId;
	
	@Column(name = "work_block_id")
	private Long workBlockId;
	
	@Column(name = "is_stoped")
	private boolean isStopedTech;

	
	public Long getCareerLocId() {
		return careerLocId;
	}

	public void setCareerLocId(Long careerLocId) {
		this.careerLocId = careerLocId;
	}

	public Long getCurZ() {
		return curZ;
	}

	public void setCurZ(Long curZ) {
		this.curZ = curZ;
	}

	public Long getSubscribedFueltruckId() {
		return subscribedFueltruckId;
	}

	public void setSubscribedFueltruckId(Long subscribedFueltruckId) {
		this.subscribedFueltruckId = subscribedFueltruckId;
	}

	public Long getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(Long interactionId) {
		this.interactionId = interactionId;
	}

	public Long getLoadLocId() {
		return loadLocId;
	}

	public void setLoadLocId(Long loadLocId) {
		this.loadLocId = loadLocId;
	}

	public Long getLuId() {
		return luId;
	}

	public void setLuId(Long luId) {
		this.luId = luId;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Long getRefuelZoneId() {
		return refuelZoneId;
	}

	public void setRefuelZoneId(Long refuelZoneId) {
		this.refuelZoneId = refuelZoneId;
	}

	public Long getShiftId() {
		return shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}

	public Long getUnloadLocId() {
		return unloadLocId;
	}

	public void setUnloadLocId(Long unloadLocId) {
		this.unloadLocId = unloadLocId;
	}

	public Long getWorkBlockId() {
		return workBlockId;
	}

	public void setWorkBlockId(Long workBlockId) {
		this.workBlockId = workBlockId;
	}

	public boolean getIsStopedTech() {
		return isStopedTech;
	}

	public void setIsStopedTech(boolean isStopedTech) {
		this.isStopedTech = isStopedTech;
	}
	
}
