package ru.itm.bkdb.entity.tables.lis;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lis_check_function", schema = "lis")
public class LisCheckFunction extends AbstractEntity {
    private String name;
    private Integer type;
    private String func;
    private String descr;

    @Override
    public String toString() {
        return "lis.lis_check_function{" +
                "id=" + id +
                ", name=" + name +
                ", type=" + type +
                ", func=" + func +
                ", descr=" + descr +
                '}';
    }

    @Override
    public String toStringShow() {
        return this.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
