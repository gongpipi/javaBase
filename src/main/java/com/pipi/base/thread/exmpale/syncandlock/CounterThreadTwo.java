package com.pipi.base.thread.exmpale.syncandlock;

/**
 * Created by pipi on 2017/5/3.
 */
public class CounterThreadTwo extends Thread {

    private Counter counter;

    public CounterThreadTwo(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true){
            Long i = counter.getIndex();
            // 如果 count 则设置为0
            if(i % 5 == 0 && i != 0){
                synchronized (counter){
                    counter.setIndex((long)0);
                }
            }
            try {
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
