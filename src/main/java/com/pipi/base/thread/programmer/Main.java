package com.pipi.base.thread.programmer;

/**
 * Created by pipi on 2017/5/3.
 */
public class Main {
    public static void  main(String args[]){
        Thread thread1 = new Mythread();
        thread1.start();

        Runnable runnable = new Mythread2();
        // 必須引用thread 构造函数才能成为thread对象
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
