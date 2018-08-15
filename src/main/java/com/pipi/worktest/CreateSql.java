package com.pipi.worktest;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateSql {

    public static void main(String[] args) throws Exception {
//        getRegisterWaySQL();
//        getIpCheckSQL();
//        getServiceState();
//        getRouteNet();
//        queryMsgSQL();
        createServiceSQL();
    }

    public static void getRegisterWaySQL() throws Exception{
        String accesscode = "D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\accesscode";
        String registerwayId = "D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\registerwayid";
        List<String> accesscodeList = new ArrayList<String>();
        List<String> registerwayIdList = new ArrayList<String>();
        Files.lines(Paths.get(accesscode), StandardCharsets.UTF_8)
                .forEach(line->{
                    accesscodeList.add(line.trim());
                        }
                );

        Files.lines(Paths.get(registerwayId), StandardCharsets.UTF_8)
                .forEach(line->{
                    registerwayIdList.add(line.trim());
                        }
                );

        for(int i=0;i<accesscodeList.size();i++){
            String sql = "update valueaddedservice set registerwayid = '"+registerwayIdList.get(i)
                    +"' where accesscode = " + accesscodeList.get(i) + ";";
            System.out.println(sql);
        }
        System.out.println("commit;");
    }


    public static void getIpCheckSQL() throws Exception{
        String path ="D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\ip鉴权\\service.txt";

        Map<String,String> ipMap = new HashMap<>();
        Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                .forEach(line->{
                    if(line!=null && !line.isEmpty()){
                        String s = line.replace("\t"," " );
                        String[] sarray= s.split(" ");
                        String rs = sarray[0].replaceAll("[\\[\\]]", ",");
                        if(rs.contains(",")){
                            String serviceId = rs.split(",")[1];
                            if(ipMap.containsKey(serviceId)){
                                ipMap.put(serviceId,ipMap.get(serviceId)+"|"+sarray[sarray.length-1]);
                            }else{
                                ipMap.put(serviceId,sarray[sarray.length-1]);
                            }

                            System.out.println(sarray[sarray.length-1]);
                        }
                    }

                        }
                );

        ipMap.forEach((k,v)->{
            String sql = "update valueaddedservice set ipaddrs='"+v+"'" + " where serviceid='" + k + "';";
            System.out.println(sql);
        });
        System.out.println("commit;");

    }


    public static void getServiceState() throws Exception{
        String accessPath="D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\accesscode";
        String statePath="D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\业务状态\\service_state";

        List<String> accesscodeList = new ArrayList<String>();
        List<String> stateList = new ArrayList<String>();
        Files.lines(Paths.get(accessPath), StandardCharsets.UTF_8)
                .forEach(line->{
                            accesscodeList.add(line.trim());
                        }
                );

        Files.lines(Paths.get(statePath), StandardCharsets.UTF_8)
                .forEach(line->{
                    stateList.add(line.trim());
                        }
                );

        for(int i=0;i<accesscodeList.size();i++){

            String sql="UPDATE VALUEADDEDSERVICE SET LEVELFLAG = '"+stateList.get(i)
                    +"' where accesscode = " + accesscodeList.get(i) + ";";
            System.out.println(sql);
        }
        System.out.println("commit;");
    }

    public static void getRouteNet() throws Exception{

        String accessPath="D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\accesscode";
        String statePath="D:\\code\\idea\\github\\javabase\\data\\sqlsourcedata\\业务路由网络id\\service_route_net";

        List<String> accesscodeList = new ArrayList<String>();
        List<String> stateList = new ArrayList<String>();
        Files.lines(Paths.get(accessPath), StandardCharsets.UTF_8)
                .forEach(line->{
                            accesscodeList.add(line.trim());
                        }
                );

        Files.lines(Paths.get(statePath), StandardCharsets.UTF_8)
                .forEach(line->{
                            stateList.add(line.trim());
                        }
                );

        for(int i=0;i<accesscodeList.size();i++){

            String sql="UPDATE VALUEADDEDSERVICE SET serviceposition = '"+stateList.get(i)
                    +"' where accesscode = " + accesscodeList.get(i) + ";";
            System.out.println(sql);
        }
        System.out.println("commit;");
    }

    static void queryMsgSQL(){
        LocalDate dateTime = LocalDate.parse("2018-02-02");
        LocalDate endTime = LocalDate.parse("2018-04-14");

        String sql = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String [] tradeId = {"t100301","t100302","t100303","t100304",
                "t100305","t100306","t100307","t100308",
                "t100309","t100310","t100313","t100314",
                "t100315","t100316","t100317","t100318",
                "t100319","t100320","t100321","t100322"
        };

//        String [] tradeIds06 = {"t100301","t100310","t100313",
//                "t100302","t100309","t100306",
//                "t100316","t100304","t100308",
//                "t100305","t100321","t100307",
//                "t100317","t100319","t100318",
//                "t100320","t100303","t100315",
//                "t100314","t100322"};

//        String [] tradeIds08 = {"t100301",
//                "t100310",
//                "t100313",
//                "t100302",
//                "t100309",
//                "t100316",
//                "t100304",
//                "t100306",
//                "t100305",
//                "t100308",
//                "t100321",
//                "t100307",
//                "t100317",
//                "t100320",
//                "t100319",
//                "t100318",
//                "t100303",
//                "t100315",
//                "t100314",
//                "t100322"
//        };

        String [] tradeIds09 = {"t100301",
                "t100310",
                "t100313",
                "t100302",
                "t100309",
                "t100316",
                "t100304",
                "t100306",
                "t100308",
                "t100305",
                "t100321",
                "t100307",
                "t100317",
                "t100320",
                "t100319",
                "t100318",
                "t100303",
                "t100315",
                "t100314",
                "t100322"
        };

//        String today = null;
//        while (dateTime.isBefore(endTime)){
//            today = dateTime.format(formatter);
////            sql = sql + " (select submittime,count(1) num from sms_cdr where SERVICE_ID = 's100304' and submittime between '" +
////                    today + " 08:00:00'" + " and '" + today + " 19:00:00'" + " group by submittime " + " ORDER BY num DESC limit 1 ) union ";
//
////            sql = sql + " (select '"+today+"', AVG(num) from  (select submittime,count(1) num from sms_cdr where SERVICE_ID = 's100304' and submittime between " +
////                    "'"+today+" 08:00:00' and '"+today+" 19:00:00' " +
////                    "group by submittime) fengzhi) union ";
//
////            sql = sql + " (select submittime,count(1) num from sms_cdr where  submittime between '" +
////                    today + " 06:30:00'" + " and '" + today + " 23:59:59'" + " group by submittime " + " ORDER BY num DESC limit 1 ) union ";
//
////            sql = sql + " (select '"+today+"', AVG(num) from  (select submittime,count(1) num from sms_cdr where  submittime between " +
////                    "'"+today+" 08:00:00' and '"+today+" 19:00:00' " +
////                    "group by submittime) fengzhi) union ";
////
//
//            dateTime = dateTime.plusDays(1);
//        }

        for(int i=0;i<tradeIds09.length;i++){
//            sql = sql + "(select s1.tradingarea_id,s1.oidd_count,s1.query_time from stat_oidd_handle as s1 " +
//                    " WHERE s1.query_time like '20180408%' and s1.oidd_count = " +
//                    " (select " +
//                    " max(s2.oidd_count) from stat_oidd_handle as s2 " +
//                    " WHERE s2.tradingarea_id = '"+tradeId[i]+"' and " +
//                    " s2.query_time like '20180408%') " +
//                    " and s1.tradingarea_id = '"+tradeId[i]+"' ) union ";

//            sql = sql + "(select MAX(oidd_count) max,'"+tradeId[i]+"' from stat_oidd_handle " +
//                    "WHERE query_time like '20180406%' and tradingarea_id='"+tradeId[i]+"') union";

//            sql = sql + "(SELECT count(1) from sms_cdr\n" +
//                    "WHERE SERVICE_ID = 'S100304'\n" +
//                    "and SUBMITTIME BETWEEN '2018-04-09 00:00:01' and '2018-04-09 23:59:59'\n" +
//                    "AND CELL_CODE IN\n" +
//                    "(select CELL_CODE from tradingarea_basesite WHERE TRADINGAREA_ID='"+tradeIds09[i]+"')) union ";

//            sql = sql + "(SELECT * from cell_count WHERE CELL_CODE in (SELECT CELL_CODE from tradingarea_basesite WHERE tradingarea_id='"+tradeIds06[i]+"')\n" +
//                    "ORDER BY num desc limit 1) union ";

//            统计忙时短信下发数
            sql = sql + "(select count(1) from sms_cdr WHERE\n" +
                    "SERVICE_ID = 'S100304' and\n" +
                    "SUBMITTIME BETWEEN '2018-04-09 16:00:00' and '2018-04-09 17:00:00'\n" +
                    "and CELL_CODE in (select CELL_CODE from tradingarea_basesite WHERE TRADINGAREA_ID='"+tradeIds09[i]+"')) union ";
        }
        System.out.println(sql);
    }

    public static void createServiceSQL() throws Exception{

        File file = new File("D:\\code\\idea\\github\\javabase\\src\\main\\resources\\service.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String[] array = tempString.split(",");

                String sql = "update VALUEADDEDSERVICE set description = '"
                        + array[1] +"' where SERVICEID = " + array[0] +";" ;
                System.out.println(sql);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
