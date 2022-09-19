package ru.itm.bkdb.entity.tables.trans;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "trans_fuel", schema = "trans")
public class TransFuel extends AbstractEntity implements Trans{

	@Column(name = "equip_id")
	private Long equipId;

	@Column(name = "shift_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar shift_date;

	@Column(name = "shift_id")
	private Long shift_id;

	@Column(name = "time_read")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timeRead;

	@Column(name = "fuel_level")
	private Double fuelLevel;


	@Column(name = "fuel_raw")
	private Double fuel_raw;
	
	@Column(name = "trans_cycles_id")
	private Long trans_cycles_id;

	@Override
	public String toString() {
		return "trans.trans_fuel" + '{' +
				"\"id\":" + id +
				", \"equip_id\":" + equipId +
				", \"shift_date\":\"" + calendarToString(shift_date) + "\"" +
				", \"shift_id\":" + shift_id +
				", \"time_read\":\"" + calendarToString(timeRead) + "\"" +
				", \"fuel_level\":" + fuelLevel +
				", \"fuel_raw\":" + fuel_raw +
				", \"trans_cycles_id\":" + trans_cycles_id +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}
	private String calendarToString(Calendar calendar){
		return (calendar!=null)?calendar.getTime().toString():"";
	}

	public TransFuel() {
	}

	public Long getEquipId() {
		return equipId;
	}

	public void setEquipId(Long equip_id) {
		this.equipId = equip_id;
	}

	public Calendar getShift_date() {
		return shift_date;
	}

	public void setShift_date(Calendar shift_date) {
		this.shift_date = shift_date;
	}

	public Long getShift_id() {
		return shift_id;
	}

	public void setShift_id(Long shift_id) {
		this.shift_id = shift_id;
	}

	public Calendar getTimeRead() {
		return timeRead;
	}

	public void setTimeRead(Calendar time_read) {
		this.timeRead = time_read;
	}

	public Double getFuel_raw() {
		return fuel_raw;
	}

	public void setFuel_raw(Double fuel_raw) {
		this.fuel_raw = fuel_raw;
	}

	public Long getTrans_cycles_id() {
		return trans_cycles_id;
	}

	public void setTrans_cycles_id(Long trans_cycles_id) {
		this.trans_cycles_id = trans_cycles_id;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	/**
	 * нет ли такой записи в базе?
	 * @param trans запись с которой сравниваем
	 * @return false если для этого оборудования не найдена временная метка
	 */
	@Override
	public boolean isForWrite(AbstractEntity trans) {
		return !timeRead.equals(((TransFuel)trans).getTimeRead()) && equipId.equals(((TransFuel)trans).equipId);
	}

}