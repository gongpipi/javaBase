package com.pipi.base.thread.exmpale.GetSet;

/**
 * Created by pipi on 2017/8/20.
 */
public class CubbyHole {

    private int contest;

    private boolean available = false;

    public synchronized int getContest() {
        try {
            while (available == false){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Custom get " + contest);
        notify();
        available = false;
        return contest;
    }

    public synchronized void setContest(int contest) {
        while (available == true){
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.contest = contest;
        available = true;
        System.out.println("Producer set " + contest);
        notify();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
