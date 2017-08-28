package com.pipi.base.thread.exmpale.GetSet;

/**
 * Created by pipi on 2017/8/20.
 */
public class Producer extends Thread {

    private CubbyHole hole;

    public Producer(CubbyHole hole){
        this.hole = hole;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            hole.setContest(i);
        }
    }
}
