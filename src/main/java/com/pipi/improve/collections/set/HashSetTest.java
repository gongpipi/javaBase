package com.pipi.improve.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pipi on 2017/7/1.
 */
public class HashSetTest {

    public static void main(String args []){
        Set<Integer> sets = new HashSet<Integer>();
        sets.add(1);
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        a.equals(b);
        System.out.println(a.equals(b));
    }
}
