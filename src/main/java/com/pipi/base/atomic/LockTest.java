package com.pipi.base.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pipi on 2017/8/21.
 */
public class LockTest {

    public int inc = 0;
    Lock lock = new ReentrantLock();

    public void increase(){
//        inc ++;
        lock.lock();
        try {
            inc ++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(10);
        LockTest test = new LockTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
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
