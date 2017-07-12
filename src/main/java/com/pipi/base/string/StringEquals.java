package com.pipi.base.string;

/**
 * Created by gongshaobo on 2017/7/12  14:04.
 */
public class StringEquals {

    public static String aa="";

    public static void main(String[] args) {

        String test = new String("1");
        String test1 = "";
        System.out.println(test.hashCode() + String.valueOf(test==""));
        System.out.println(test.intern());

    }
}
