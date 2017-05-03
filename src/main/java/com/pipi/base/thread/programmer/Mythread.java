package com.pipi.base.thread.programmer;

/**
 * Created by pipi on 2017/5/3.
 */
public class Mythread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("hello thread");
    }
}
