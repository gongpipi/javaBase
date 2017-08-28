package com.pipi.base.thread.exmpale.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pipi on 2017/8/23.
 */
public class DefaultThreadPool<Job extends Runnable> {

    private static final int DEFAULT_POOL_NUMBER = 10;
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    private List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    public DefaultThreadPool(){
        initializeWokers(DEFAULT_POOL_NUMBER);
    }

    public void shutdown(){

    }

    public void addWorkers() {

    }

    public void removeWorkers() {

    }
    // 初始化线程池
    private void initializeWokers (int num) {
        for(int i=0; i<num; i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-" + i);
            thread.start();
        }
    }


    // 执行任务
    public void excute (Job job) {
        if(job != null){
            // 获得任务锁
            synchronized (jobs) {
                jobs.add(job);
                // 通知作用在任务jobs的线程
                jobs.notify();
            }
        }

    }

    // 工作者
    class Worker implements Runnable {

        private volatile boolean running = true;
        @Override
        public void run() {

            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        // 如果任务队列为空则当前线程等待
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 取出一个job
                    job = jobs.removeFirst();
                }
                // job 不为空则执行任务
                if(job != null) {
                    job.run();
                }
            }
        }

        public void shutdown(){
            running =false;
        }
    }

}
