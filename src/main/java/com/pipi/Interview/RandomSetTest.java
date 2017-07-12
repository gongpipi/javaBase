package com.pipi.Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by pipi on 2017/7/5.
 */
public class RandomSetTest {

    public static void main(String args[]){

        int key = 0;

        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(key,"a");
        key ++;
        map.put(key,"b");
        key ++;
        map.put(key,"c");
        key ++;
        map.put(key,"d");
        key ++;
        map.put(key,"e");
        key ++;
        Random random = new Random();
        int n2 = Math.abs(random.nextInt() % map.size());
        System.out.println(map.get(n2));

        String aa = new String("123");
        String ab = "123";
        System.out.println(aa.hashCode());
        System.out.println(ab.hashCode());

    }
}
