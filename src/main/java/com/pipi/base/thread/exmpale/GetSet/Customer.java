package com.pipi.base.thread.exmpale.GetSet;

/**
 * Created by pipi on 2017/8/20.
 */
public class Customer extends Thread {

    private CubbyHole hole;

    public Customer(CubbyHole hole){
        this.hole = hole;
    }

    @Override
    public void run() {
        int value;
        for(int i=0;i<10;i++){
            value =hole.getContest();
        }
    }
}
