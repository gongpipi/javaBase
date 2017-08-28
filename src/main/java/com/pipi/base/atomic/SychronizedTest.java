package com.pipi.base.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pipi on 2017/8/21.
 */
public class SychronizedTest {

    public int inc = 0;

    public synchronized void increase(){
        inc ++;
    }

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(10);

        final SychronizedTest test = new SychronizedTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10;j++)
                        test.increase();
                    latch.countDown();
                }
            }.start();
        }

//        while(Thread.activeCount()>1)  //保证前面的线程都执行完
//            Thread.yield();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(test.inc);
    }
}
