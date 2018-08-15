package com.pipi.fun;

public class Singleton1{
    private static class lazyLoader{
        private static final Singleton1 INSTANCE = new Singleton1();
    }
    private Singleton1(){
//        System.out.println("真正实例化");
    }
    public static final Singleton1 getInstance(){
//        System.out.println("调用内部类");
        Singleton1 s = lazyLoader.INSTANCE;
//        System.out.println("调用结束");
        return s ;
    }


    private static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println(getInstance());
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<100;i++){
            new MyThread().start();
        }
    }
}


