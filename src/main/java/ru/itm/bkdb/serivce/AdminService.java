package ru.itm.bkdb.serivce;

public interface AdminService {
    String getData();
    String getTables();

    String updateTables();

    String sendAll(String trans_cycles);
    boolean isTabValid(String tab);
}
