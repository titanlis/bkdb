package ru.itm.bkdb.entity.tables.material;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "material_conv", schema = "material")
public final class MaterialConversation extends AbstractEntity {

	@Column(name = "material_id")
	private Long materialId;
	
	@Column(name = "loc_id")
	private Long locId;
	
	private Double value;
	
	public MaterialConversation(){}
}
