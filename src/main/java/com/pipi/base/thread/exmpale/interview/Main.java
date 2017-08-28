package com.pipi.base.thread.exmpale.interview;

/**
 * Created by pipi on 2017/8/21.
 */
public class Main {

    public static void main(String[] args) {
        Nuum nuum = new Nuum();

        new Thread(()->{
            nuum.setb1();
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                nuum.setB2();
            }
        }).start();

        new Thread(()->{
            nuum.outB();
        }).start();
    }
}
