package com.pipi.base.thread.exmpale.ifeve;

import java.util.concurrent.TimeUnit;

/**
 * Created by pipi on 2017/8/23.
 */
public class Shutdown {

    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"oneThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"twoThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }


    private static class Runner implements Runnable {

        private long i;

        private volatile boolean on =true;

        @Override
        public void run() {

            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i= " + i);
        }

        public void cancel(){
            on = false ;
        }
    }
}
