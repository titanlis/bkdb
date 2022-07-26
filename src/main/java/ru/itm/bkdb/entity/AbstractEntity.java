package ru.itm.bkdb.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @class AbstractEntity абстрактный класс для всех сущностей
 */
@MappedSuperclass   // — Hibernate тоже должен узнать, что это абстракция.
public abstract class AbstractEntity{

    protected Long id;    //id есть у каждой сущности

    @Id
    //@GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}