package ru.itm.bkdb.entity.tables.location;

import ru.itm.bkdb.entity.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "routes_roads", schema = "location")
public class RoutesRoads extends AbstractEntity {
    private Long route_id;
    private Long road_id;
    private Long number;

    public RoutesRoads() { }

    @Override
    public String toString() {
        return "location.routes_roads{" +
                "id=" + id +
                ", route_id=" + route_id +
                ", road_id=" + road_id +
                ", number=" + number +
                '}';
    }

    @Override
    public String toStringShow() {
        return this.toString();
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public Long getRoad_id() {
        return road_id;
    }

    public void setRoad_id(Long road_id) {
        this.road_id = road_id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
