package com.pipi.improve.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pipi on 2017/7/5.
 */
public class HashMapTest {

    public static void main(String args []){

        Map<Integer,String> map = new HashMap<Integer, String>();
        HashMap<Integer,String> hashMap = new HashMap<Integer, String>();
        // 1. 移除
        map.remove("key");
        // 2. 大小
        map.size();
        // 3. 放入
        map.put(1,"1");
        // 4. 包含key
        map.containsKey(1);
        // 5. 包含某个值
        map.containsValue("1");
        // 6. 比较相同
        map.equals("1");
        // 7. 获取
        map.get("key");
        map.keySet();
        map.values();
        map.clear();

    }
}
