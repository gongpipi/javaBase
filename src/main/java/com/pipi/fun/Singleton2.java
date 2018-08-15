package com.pipi.fun;

public class Singleton2 {

    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){
        System.out.println("初始化");
    }

    public static Singleton2 getInstance(){
        System.out.println("调用前");
        Singleton2 s = singleton2;
        System.out.println("调用后");
        return s;
    }

    public static void main(String[] args) {
        getInstance();
    }
}
