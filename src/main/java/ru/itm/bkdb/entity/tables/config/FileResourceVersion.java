package ru.itm.bkdb.entity.tables.config;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "file_resource_version", schema = "config")
public class FileResourceVersion extends AbstractEntity {
	private String resource_name;
	private String hash;
	private String version;
	private Calendar date;

	public FileResourceVersion() {}
}
