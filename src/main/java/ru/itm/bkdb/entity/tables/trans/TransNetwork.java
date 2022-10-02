package ru.itm.bkdb.entity.tables.trans;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "trans_network", schema = "trans")
public class TransNetwork extends AbstractEntity implements Trans{

    @Column(name = "equip_id", nullable = false)
    private Long equipId;                           //id техники

    @Column(name = "equip_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar equipTime;                     //Время записи

    @Column(name = "trans_coord_id", nullable = false)
    private Long transCoordId;                      //Ссылка на таблицу trans_coord, по которым координатам проведен замер качества связи

    @Column(name = "ap_mac")
    private String apMac;                           //MAC адрес точки доступа через которую работает оборудование

    @Column(name = "level")
    private Integer level;

    @Column(name = "ping")
    private Integer ping;

    @Column(name = "speed")
    private Integer speed;

    @Deprecated
    public TransNetwork() {}

    public TransNetwork(Long equipId, Calendar equipTime, Long transCoordId, String apMac, Integer level, Integer ping, Integer speed) {
        this.equipId = equipId;
        this.equipTime = equipTime;
        this.transCoordId = transCoordId;
        this.apMac = apMac;
        this.level = level;
        this.ping = ping;
        this.speed = speed;
    }

    public TransNetwork(TransNetwork t) {
        this.equipId = t.equipId;
        this.equipTime = t.equipTime;
        this.transCoordId = t.transCoordId;
        this.apMac = t.apMac;
        this.level = t.level;
        this.ping = t.ping;
        this.speed = t.speed;
    }

    @Override
    public String toString() {
        return "trans.trans_network" + '{' +
                "\"id\":" + id +
                ", \"equip_id\":" + equipId +
                ", \"trans_coord_id\":\"" + transCoordId + "\"" +
                ", \"ap_mac\":\"" + apMac + "\"" +
                ", \"level\":\"" + level + "\"" +
                ", \"ping\":\"" + ping + "\"" +
                ", \"speed\":\"" + speed + "\"" +
                '}';
    }


    public Calendar getEquipTime() {
        return equipTime;
    }

    public void setEquipTime(Calendar equipTime) {
        this.equipTime = equipTime;
    }

    public Long getTransCoordId() {
        return transCoordId;
    }

    public void setTransCoordId(Long transCoordId) {
        this.transCoordId = transCoordId;
    }

    public String getApMac() {
        return apMac;
    }

    public void setApMac(String apMac) {
        this.apMac = apMac;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPing() {
        return ping;
    }

    public void setPing(Integer ping) {
        this.ping = ping;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Override
    public Long getEquipIdTrans() {
        return equipId;
    }

    @Override
    public Calendar getTime() {
        return equipTime;
    }

}
