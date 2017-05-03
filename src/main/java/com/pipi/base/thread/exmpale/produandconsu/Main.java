package com.pipi.base.thread.exmpale.produandconsu;

/**
 * Created by pipi on 2017/5/3.
 */
public class Main {

    public static void main(String args []){
        DataSet dataSet = new DataSet();
        dataSet.setMaxNum(10);
        dataSet.setFactorialAddition((long)0);

        ProducerThread producerThread = new ProducerThread(dataSet);
        producerThread.start();

        ConsumerThread consumerThread = new ConsumerThread(dataSet);
        consumerThread.start();
    }
}
