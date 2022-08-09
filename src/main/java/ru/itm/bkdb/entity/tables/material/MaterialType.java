package ru.itm.bkdb.entity.tables.material;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "material_type", schema = "material")
public final class MaterialType extends AbstractEntity {
	private String name;
	private String description;

	public MaterialType(){}

	@Override
	public String toString() {
		return "material.material_type{" +
				"id=" + id +
				", name=" + name +
				", description=" + description +
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
}
