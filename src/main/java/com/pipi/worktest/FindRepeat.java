package com.pipi.worktest;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class FindRepeat {

    public static void main(String[] args) throws Exception {
        long begin = Instant.now().toEpochMilli();
        HashMap<String,Integer> firstMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0205-1315.log");
        HashMap<String,Integer> seconMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0205-1926.log");
        HashMap<String,Integer> thirdMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0205-2359.log");
        HashMap<String,Integer> fourthMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0206-1113.log");
        HashMap<String,Integer> fifthMap = FindRepeat.getHashMap("D:\\code\\idea\\github\\javabase\\data\\0206-1811.log");


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

//        fourthMap.forEach((s,i)->{
//            if(firstMap.containsKey(s)){
//                firstMap.put(s,firstMap.get(s)+1);
//            }else {
//                firstMap.put(s,1);
//            }
//        });

        fifthMap.forEach((s,i)->{
            if(fourthMap.containsKey(s)){
                fourthMap.put(s,fourthMap.get(s)+1);
            }else {
                fourthMap.put(s,1);
            }
        });

        int[] com={0};

        fifthMap.forEach((s,i)->{
            if(fourthMap.containsKey(s)){
                com[0]++;
            }
        });



        int [] max={0,0,0,0,0,0,0,0,0,0,0,0};
        firstMap.forEach((s,i)->{
            if(i==0){
                max[0]++;
            }
            if(i==1){
                max[1]++;
            }
            if(i==2){
                max[2]++;
            }
            if(i==3){
                max[3]++;
            }
            if(i==4){
                max[4]++;
            }
            if(i==5){
                max[5]++;
            }
            if(i==6){
                max[6]++;
            }
            if(i==7){
                max[7]++;
            }
            if(i==8){
                max[8]++;
            }
            if(i==9){
                max[9]++;
            }
            if(i==10){
                max[10]++;
            }
        });

        System.out.println(max[0]+ " "+ max[1]+ " "+ max[2]+ " "+ max[3]
                + " "+ max[4]+ " "+ max[5]+ " "+ max[6]+ " "+ max[7]
                + " "+ max[8]+ " "+ max[9]+ " "+ max[10]);

        System.out.println("总号码数为" +firstMap.keySet().size() + " 两天的重复数" + com[0]);

        long end = Instant.now().toEpochMilli();

        System.out.println(end-begin);


    }

    private static void testHashset() throws Exception{

//        HashSet<String> numbers = new HashSet<String>(330000);
//        ConcurrentLinkedQueue<String> numbers = new ConcurrentLinkedQueue<String>();
        ConcurrentSkipListSet<String> numbers = new ConcurrentSkipListSet<String>();
        int [] i ={0};
        Files.lines(Paths.get("D:\\code\\idea\\github\\javabase\\src\\main\\resources\\mdn.log"), StandardCharsets.UTF_8)
                .forEach(line->{
                            String[] array = line.split(" ");
                            String num = array[array.length-1].trim();
                            if(numbers.contains(num)){
                                System.out.println(num);
                                i[0]=i[0]+1;
                            }else{
                                numbers.add(num);
                            }
                        }
                );
        System.out.println("号码数" +numbers.size()+ " 重复号码数" + i[0]);

        HashSet<String> kafkaNums = new HashSet<String>(100000);
        numbers.forEach(nu->{
            if(nu.startsWith("86")||nu.length()==11){
                kafkaNums.add(nu);
            }
        });

        System.out.println("放入队列的数量 " + kafkaNums.size());
    }

    public static HashMap<String,Integer> getHashMap(String path) throws Exception{
        int [] i ={0};
        HashMap<String,Integer> numbers = new HashMap<String,Integer>(400000);
        Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                .forEach(line->{
                            String[] array = line.split(" ");
                            String num = array[array.length-1].trim();
                            if(numbers.containsKey(num)){
                                numbers.put(num, numbers.get(num)+1);
                            }else{
                                numbers.put(num,1);
                            }
                            i[0]=i[0]+1;
                        }
                );

        return numbers;

    }



}
