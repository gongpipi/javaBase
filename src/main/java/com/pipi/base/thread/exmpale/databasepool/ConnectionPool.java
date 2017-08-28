package com.pipi.base.thread.exmpale.databasepool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by pipi on 2017/8/23.
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize) {
        if(initialSize > 0) {
            for(int i=0; i< initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }
}
