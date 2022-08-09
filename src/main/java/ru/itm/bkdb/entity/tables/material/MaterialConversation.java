package ru.itm.bkdb.entity.tables.material;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "material_conv", schema = "material")
public final class MaterialConversation extends AbstractEntity {

	private Long material_id;
	private Long loc_id;
	private Double value_data;
	
	public MaterialConversation(){}

	@Override
	public String toString() {
		return "material.material_conv{" +
				"id=" + id +
				", material_id=" + material_id +
				", loc_id=" + loc_id +
				", value_data=" + value_data +
				'}';
	}

	@Override
	public String toStringShow() {
		return this.toString();
	}

	public Long getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(Long material_id) {
		this.material_id = material_id;
	}

	public Long getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(Long loc_id) {
		this.loc_id = loc_id;
	}

	public Double getValueData() {
		return value_data;
	}

	public void setValueData(Double value_data) {
		this.value_data = value_data;
	}
}
