package com.pipi.database;

import com.pipi.database.model.PhoneNumber;
import com.pipi.worktest.FindRepeat;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class MysqlConnect {

    public static void main(String[] args) throws Exception{

        Connection connection = customGetConnect();
        connection.createStatement();

        long begin = Instant.now().toEpochMilli();
        HashMap<String,Integer> firstMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0205-1315.log");
        HashMap<String,Integer> seconMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0205-1926.log");
        HashMap<String,Integer> thirdMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0205-2359.log");
        HashMap<String,Integer> fourthMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0206-1113.log");

        seconMap.forEach((s,i)->{
            if(firstMap.containsKey(s)){
                firstMap.put(s,firstMap.get(s)+1);
            }else {
                firstMap.put(s,1);
            }
        });


        thirdMap.forEach((s,i)->{
            if(firstMap.containsKey(s)){
                firstMap.put(s,firstMap.get(s)+1);
            }else {
                firstMap.put(s,1);
            }
        });

        fourthMap.forEach((s,i)->{
            if(firstMap.containsKey(s)){
                firstMap.put(s,firstMap.get(s)+1);
            }else {
                firstMap.put(s,1);
            }
        });



//        int [] max={0,0};
//        firstMap.forEach((s,i)->{
//            if(i==5){
//                max[0]++;
//            }
//        });

        int [] max={0,0};
        firstMap.forEach((s,i)->{

            String qrySql = "select * from phone_number where number ='"+s+"'";
            PhoneNumber phoneNumber = excuteQry(connection,qrySql);
            if(phoneNumber==null){

                String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:ss.SSS"));
                String saveSql = "INSERT into phone_number VALUES('"+s+"','"+dateTime+"')";
                storeData(connection,saveSql);
            }


        });

    }

    public static Connection customGetConnect() throws Exception{
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                    "user=root&password=root&serverTimezone=UTC");
            DatabaseMetaData meta = c.getMetaData();
// gets driver info:
            System.out.println("JDBC driver version is " + meta.getDriverVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static PhoneNumber excuteQry(Connection conn,String sql){
        Statement stmt = null;
        ResultSet rs = null;
        PhoneNumber phoneNumber= null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if(rs.next()){
                phoneNumber=new PhoneNumber();
                phoneNumber.setNumber(rs.getString("number"));
            }

        }
        catch (SQLException ex){
// handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
// it is a good idea to release
// resources in a finally{} block
// in reverse-order of their creation
// if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return phoneNumber;
    }

    public static void storeData(Connection conn,String sql){
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            rs = stmt.getResultSet();
        }
        catch (SQLException ex){
// handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
    }
}
