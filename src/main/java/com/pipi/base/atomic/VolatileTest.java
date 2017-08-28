package com.pipi.base.atomic;

/**
 * Created by pipi on 2017/8/21.
 *
 * main方法理应输出
 * volatile 的作用，立即将线程中该变量的值，更新到主内存中。
 * 很奇怪，debug可以执行结束，run不能执行结束
 */
public class VolatileTest {

    public volatile int inc = 0;

    public void increase(){
        inc ++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();

        for(int i=0; i< 10; i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    test.increase();
                }
            }).start();
        }
        while(Thread.activeCount()>1) {

            try {
                Thread.sleep(10*1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            //保证前面的线程都执行完
//            Thread.yield();
            // Thread.yield( )方法，很多人翻译成线程让步。
            // 顾名思义，就是说当一个线程使用了这个方法之后，
            // 它就会把自己CPU执行的时间让掉，让自己或者其它的线程运行。
        }
        System.out.println(test.inc);

    }

}
