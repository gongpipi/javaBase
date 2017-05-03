package com.pipi.base.thread.exmpale.syncandlock;

/**
 * Created by pipi on 2017/5/3.
 */
public class CounterThread extends Thread {

    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        for(int i = 0; i<1000;i++){
            Long dex = counter.getIndex();
            // count 加一
            synchronized (counter){
                counter.setIndex(++dex);
            }

            try {
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
