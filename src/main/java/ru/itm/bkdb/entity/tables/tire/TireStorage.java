package ru.itm.bkdb.entity.tables.tire;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tire_storage", schema = "tire")
public final class TireStorage extends AbstractEntity {
	private String name;
	private String description;
	private Integer max_storage;

	public TireStorage() {}

	@Override
	public String toString() {
		return "tire.tire_storage{" +
				"name=" + name +
				", description=" + description +
				", max_storage=" + max_storage +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMax_storage() {
		return max_storage;
	}

	public void setMax_storage(Integer max_storage) {
		this.max_storage = max_storage;
	}
}
