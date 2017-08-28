package com.pipi.base.lang.string;

/**
 * Created by gongshaobo on 2017/7/12  14:04.
 */
public class StringEquals {

    public static String aa="";

    public static void main(String[] args) {

        String test = new String("16");
        String test1 = "16";
        System.out.println(test.hashCode() == test1.hashCode());
        System.out.println(test.equals(test1));
        System.out.println(test.intern());

    }
}
