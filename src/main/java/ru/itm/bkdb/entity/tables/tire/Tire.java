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
	private String install_date;
	private String manuf_date;
	private String manufacturer;

	public Tire() {}

	@Override
	public String toString() {
		return "tire.tires{" +
				"sn=" + sn +
				", maxtemp=" + maxtemp +
				", mintemp=" + mintemp +
				", maxpress=" + maxpress +
				", minpress=" + minpress +
				", tkph=" + tkph +
				", size=" + size +
				", install_date=" + install_date +
				", manuf_date=" + manuf_date +
				", manufacturer=" + manufacturer +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Double getMaxtemp() {
		return maxtemp;
	}

	public void setMaxtemp(Double maxtemp) {
		this.maxtemp = maxtemp;
	}

	public Double getMintemp() {
		return mintemp;
	}

	public void setMintemp(Double mintemp) {
		this.mintemp = mintemp;
	}

	public Double getMaxpress() {
		return maxpress;
	}

	public void setMaxpress(Double maxpress) {
		this.maxpress = maxpress;
	}

	public Double getMinpress() {
		return minpress;
	}

	public void setMinpress(Double minpress) {
		this.minpress = minpress;
	}

	public Double getTkph() {
		return tkph;
	}

	public void setTkph(Double tkph) {
		this.tkph = tkph;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getInstall_date() {
		return install_date;
	}

	public void setInstall_date(String install_date) {
		this.install_date = install_date;
	}

	public String getManuf_date() {
		return manuf_date;
	}

	public void setManuf_date(String manuf_date) {
		this.manuf_date = manuf_date;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
