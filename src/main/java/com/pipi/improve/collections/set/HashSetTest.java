package com.pipi.improve.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pipi on 2017/7/1.
 */
public class HashSetTest {

    public static void main(String args []){
        Set<Integer> sets = new HashSet<Integer>();
        HashSet<String> hashSet = new HashSet<String>();
        sets.add(1);
        Integer a = 1;
        Integer b = 2;
        a.equals(b);

        String asd = "111";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
//        hashSet.
        System.out.println(a.equals(b));
    }
}
