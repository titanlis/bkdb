package ru.itm.bkdb.entity;

import ru.itm.bkdb.entity.tables.trans.TransFuel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @class AbstractEntity абстрактный класс для всех сущностей
 */
@MappedSuperclass   // — Hibernate тоже должен узнать, что это абстракция.
public abstract class AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;    //id есть у каждой сущности


    //@GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract String toStringShow();
}