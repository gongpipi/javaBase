package com.pipi.base.inherit;

/**
 * Created by pipi on 2017/8/20.
 */
public interface TestInterFace {

    String  var1 = "233";

    public String test();

    // java8 新特性
    public static  String test2() {
        return null;
    };

    // java8 新特性
    default String test1(){
        return null;
    }
}
