package com.pipi.base.thread.exmpale.ifeve;

import javax.management.ObjectName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by pipi on 2017/8/23.
 */
public class WaitNotify {
    static  boolean flag = true;
    static Object object = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {

            synchronized (object) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true. wait@" +
                                new SimpleDateFormat("HH:mm:sss").format(new Date()));
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread() + "flag is false. end@" +
                        new SimpleDateFormat("HH:mm:sss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {

            synchronized (object) {
                // 获取锁之后，通知其他线程。通知时不会释放锁，直到当前的线程释放了lock后，
                // waitthread 才能 从wait方法中返回
                flag = false;
                System.out.println(Thread.currentThread() + "hold lock. notify@" +
                        new SimpleDateFormat("HH:mm:sss").format(new Date()));
                object.notify();

            }

            synchronized (object) {
                System.out.println(Thread.currentThread() + "hold lock again. notify@" +
                        new SimpleDateFormat("HH:mm:sss").format(new Date()));

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e ) {
                    e.printStackTrace();
                }
            }

        }
    }
}
