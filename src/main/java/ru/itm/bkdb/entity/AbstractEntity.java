package ru.itm.bkdb.entity;

import ru.itm.bkdb.entity.tables.trans.TransFuel;

import javax.persistence.*;

/**
 * @class AbstractEntity абстрактный класс для всех сущностей
 */
@MappedSuperclass   // — Hibernate тоже должен узнать, что это абстракция.
public abstract class AbstractEntity{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//.SEQUENCE)
//    @SequenceGenerator(name = "seq",
//            sequenceName = "sequence",
//            initialValue = 1, allocationSize = 20)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    protected Long id;    //id есть у каждой сущности

    //@GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toStringShow(){return toString();};

    public boolean isEnding() { return true; }
}