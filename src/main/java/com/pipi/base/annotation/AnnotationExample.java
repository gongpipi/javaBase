package com.pipi.base.annotation;

/**
 * Created by pipi on 2017/8/28.
 */
public class AnnotationExample {
    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "pipi1",date = "2017",comment = "转字符串")
    public String toString(){
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(date = "2017下午",comment = "被遗弃的方法")
    public static void oldMethod(){
        System.out.println("过期的方法，建议不要用");
    }



}
