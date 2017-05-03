package com.pipi.base.thread.exmpale.produandconsu;

/**
 * Created by pipi on 2017/5/3.
 */
public class ConsumerThread extends Thread {

    public DataSet dataSet;

    public ConsumerThread(DataSet dataSet){
        this.dataSet = dataSet;
    }

    @Override
    public void run(){
        while (true){
            if(dataSet.getCurrentNum().equals(dataSet.getMaxNum())){
                break;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前最大值为：" + dataSet.getCurrentNum() + " 当前总和为"+ dataSet.getFactorialAddition());
        }

    }
}
