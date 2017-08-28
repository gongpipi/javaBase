package com.pipi.base.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pipi on 2017/8/21.
 */
public class IncreaseTest {

    public int inc =0;

    public void increase(){
        inc ++;
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        IncreaseTest test = new IncreaseTest();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++)
                    test.increase();
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(5*1000);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(test.inc);

    }
}
