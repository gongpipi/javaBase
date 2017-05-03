package com.pipi.base.thread.programmer;

/**
 * Created by pipi on 2017/5/3.
 */
public class Mythread2 implements Runnable {

    public void run() {

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Hello thread2");
    }
}
