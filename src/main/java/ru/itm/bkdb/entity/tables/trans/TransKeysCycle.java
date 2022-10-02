package ru.itm.bkdb.entity.tables.trans;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "trans_keys_cycle", schema = "trans")
public class TransKeysCycle extends AbstractEntity implements Trans{

    @Column(name = "id_trans_cycle", nullable = false)
    private Long idTransCycle;

    @Column(name = "id_trans_sensor", nullable = false)
    private Long idTransSensor;

    @Column(name = "sensor_data_type_id", nullable = false)
    private Long sensorDataTypeId;

    public Long getIdTransCycle() {
        return idTransCycle;
    }

    public void setIdTransCycle(Long idTransCycle) {
        this.idTransCycle = idTransCycle;
    }

    public Long getIdTransSensor() {
        return idTransSensor;
    }

    public void setIdTransSensor(Long idTransSensor) {
        this.idTransSensor = idTransSensor;
    }

    public Long getSensorDataTypeId() {
        return sensorDataTypeId;
    }

    public void setSensorDataTypeId(Long sensorDataTypeId) {
        this.sensorDataTypeId = sensorDataTypeId;
    }

    public TransKeysCycle(Long idTransCycle, Long idTransSensor, Long sensorDataTypeId) {
        this.idTransCycle = idTransCycle;
        this.idTransSensor = idTransSensor;
        this.sensorDataTypeId = sensorDataTypeId;
    }

    public TransKeysCycle(TransKeysCycle t) {
        this.idTransCycle = t.idTransCycle;
        this.idTransSensor = t.idTransSensor;
        this.sensorDataTypeId = t.sensorDataTypeId;
    }

    @Override
    public String toString() {
        return "trans.trans_keys_cycle" + '{' +
                "\"id\":" + id +
                ", \"id_trans_cycle\":" + idTransCycle +
                ", \"id_trans_sensor\":\"" + idTransSensor + "\"" +
                ", \"sensor_data_type_id\":\"" + sensorDataTypeId + "\"" +
                '}';
    }


    @Deprecated
    public TransKeysCycle() {
    }

    @Override
    public Long getEquipIdTrans() {
        return null;
    }

    @Override
    public Calendar getTime() {
        return null;
    }
}