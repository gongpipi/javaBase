package com.pipi.base.thread.exmpale.threadpool;

import java.util.LinkedList;

/**
 * Created by pipi on 2017/8/21.
 */
public  class MyThreadPool {

    private  int nThreads;

    private  LinkedList queue;

    private  WorkThread [] workThreads;

    public MyThreadPool(int nThreads){
        this.nThreads = nThreads;
        queue = new LinkedList();
        workThreads = new WorkThread[nThreads];
        for (WorkThread thread: workThreads) {
            thread.start();
        }
    }

    public void excute(Runnable runnable){
        synchronized (queue) {
            queue.addLast(runnable);
            queue.notify();
        }
    }

    private class WorkThread extends Thread {
        @Override
        public void run() {
            Runnable r;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try{
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = (Runnable) queue.removeFirst();
                }

                try {
                    r.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
