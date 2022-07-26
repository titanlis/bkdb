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
}
