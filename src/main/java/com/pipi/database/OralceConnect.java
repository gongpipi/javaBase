package com.pipi.database;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OralceConnect {

    public static void main(String[] args) throws Exception {

        Queue<Connection> conns = new ConcurrentLinkedQueue<>();

        for(int i=1;i<10000;i++){
            Thread.sleep(500);
            try {
//                officeGetConnect();
                conns.add(customGetConnect());
            }catch (Exception e){
                System.out.println(i);
                break;
            }
        }

        while (conns.size()>0){
            Connection connection = conns.poll();
            connection.close();
        }

    }


    public static Connection customGetConnect() throws Exception{
                Connection c = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

//            c = DriverManager.getConnection("jdbc:oracle:thin:@10.18.13.229:1521:emsp", "smsc3", "smsc3");
            c = DriverManager.getConnection("jdbc:oracle:oci:@emsp", "smsc3", "smsc3");
            DatabaseMetaData meta = c.getMetaData();
// gets driver info:
            System.out.println("JDBC driver version is " + meta.getDriverVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }



    public static Connection officeGetConnect()  throws Exception{
        OracleDataSource ods = new OracleDataSource();
//        thin连接
//        ods.setURL("jdbc:oracle:thin:sys/oracle@192.168.56.129:1521:PROD");
//        jdbc oci连接
        ods.setURL("jdbc:oracle:oci:sys/oracle@PROD");
        Connection conn = ods.getConnection();
// Create Oracle DatabaseMetaData object
        DatabaseMetaData meta = conn.getMetaData();
// gets driver info:
        System.out.println("JDBC driver version is " + meta.getDriverVersion());
        return conn;
    }
}
