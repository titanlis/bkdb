package ru.itm.bkdb.udp;

import java.util.List;

/**
 * Класс для передачи kryo серилизованной таблицы
 */
public class DBModelContainer {
    private List<byte[]> data;      // список данных из таблицы в kryo
    private String tableName;       // имя таблицы

    public DBModelContainer() {
    }

    public DBModelContainer(List<byte[]> data, String tableName) {
        this.data = data;
        this.tableName = tableName;
    }

    public List<byte[]> getData() {
        return data;
    }

    public void setData(List<byte[]> data) {
        this.data = data;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
