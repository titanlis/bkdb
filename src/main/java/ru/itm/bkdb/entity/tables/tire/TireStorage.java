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
	
	@Column(name = "max_storage")
	private Integer maxStorage;

	@Override
	public String toStringShow() {
		return null;
	}
}
