package ru.itm.bkdb.entity.tables.material;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="material", schema="material")
public class Material extends AbstractEntity {
	private String name;
	private Long material_type_id;
	private String color;
	private Boolean active;

	public Material() {}

	@Override
	public String toString() {
		return "material.material{" +
				"id=" + id +
				", name=" + name +
				", material_type_id=" + material_type_id +
				", color=" + color +
				", active=" + active +
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

	public Long getMaterial_type_id() {
		return material_type_id;
	}

	public void setMaterial_type_id(Long material_type_id) {
		this.material_type_id = material_type_id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
