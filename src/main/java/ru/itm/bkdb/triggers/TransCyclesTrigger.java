package ru.itm.bkdb.triggers;

import org.h2.tools.TriggerAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransCyclesTrigger extends TriggerAdapter {
    @Override
    public void fire(Connection conn, ResultSet oldRow, ResultSet newRow) throws SQLException {
        System.out.println("==========TRIGGER===========");
    }
}



/*
    DROP TRIGGER IF EXISTS trans.TRIGGERAFTERUPDATECYCLES;

    CREATE TRIGGER TriggerAfterUpdateCycles
        AFTER UPDATE
        ON TRANS.TRANS_CYCLES
        FOR EACH ROW
        CALL 'ru.itm.bkdb.triggers.TransCyclesTrigger'
 */