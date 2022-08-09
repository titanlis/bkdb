package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "routes", schema = "location")
public class Routes extends AbstractEntity {
    private Long loc_start_id;
    private Long loc_end_id;

    public Routes() {}

    @Override
    public String toString() {
        return "location.routes{" +
                "id=" + id +
                ", loc_start_id=" + loc_start_id +
                ", loc_end_id=" + loc_end_id +
                '}';
    }

    @Override
    public String toStringShow() {
        return this.toString();
    }

    public Long getLoc_start_id() {
        return loc_start_id;
    }

    public void setLoc_start_id(Long loc_start_id) {
        this.loc_start_id = loc_start_id;
    }

    public Long getLoc_end_id() {
        return loc_end_id;
    }

    public void setLoc_end_id(Long loc_end_id) {
        this.loc_end_id = loc_end_id;
    }
}
