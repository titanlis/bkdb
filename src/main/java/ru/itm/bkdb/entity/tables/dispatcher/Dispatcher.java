package ru.itm.bkdb.entity.tables.dispatcher;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Используется на бк для определения текущего диспетчера.
 * На сервере есть еще логин и пароль диспетчера, но на бк они не нужны.
 * Водитель просто теперь знает имя диспетцера.
 */
@Entity
@Table(name = "dispatcher", schema = "dispatcher")
public final class Dispatcher extends AbstractEntity {
	private String name;

	public Dispatcher() {}

	public String toStringShow() {
		return "[id=" + id + ", name =\'" + name +"\']";
	}
}
