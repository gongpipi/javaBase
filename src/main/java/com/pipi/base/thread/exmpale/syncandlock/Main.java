package com.pipi.base.thread.exmpale.syncandlock;

/**
 * Created by pipi on 2017/5/3.
 */
public class Main {

    public static void main(String args []) throws Exception{
        Counter counter = new Counter();
        counter.setIndex((long)0);
        CounterThread counterThread1 = new CounterThread(counter);
        CounterThreadTwo counterThreadTwo = new CounterThreadTwo(counter);

        counterThread1.start();
        counterThreadTwo.start();
        // 在主线程中访问
        while (true){
            System.out.println("计数值为" + counter.getIndex());
            Thread.sleep(1000);
        }

    }
}
