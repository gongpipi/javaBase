package com.pipi.base.lang.interger;

/**
 * Created by pipi on 2017/8/20.
 */
public class IntergerTest {

    public static void main(String[] args) {
        Integer i = 100;
        Integer i2 = new Integer(100);
        i = i>>2;
        i.equals(i2);
        i.hashCode();
        i.toString();
    }
}
