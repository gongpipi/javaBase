package com.pipi.improve.collections.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pipi on 2017/8/27.
 */
public class ConcurrentHashMapTest {

    static  ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        hashMap.put("","");
        AtomicInteger integer = null;
    }
}
