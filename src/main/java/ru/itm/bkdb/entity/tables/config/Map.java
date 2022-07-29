package ru.itm.bkdb.entity.tables.config;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "map_data", schema = "config")
public final class Map extends AbstractEntity {
	@Column(name = "map_version")
	private String mapVersion;

	@Column(name = "map_name")
	private String mapName;

	@Column(name = "map_hash")
	private String mapHash;

	public Map(){}

	@Override
	public String toStringShow() {
		return null;
	}
}
