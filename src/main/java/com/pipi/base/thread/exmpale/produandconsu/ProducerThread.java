package com.pipi.base.thread.exmpale.produandconsu;

/**
 * Created by pipi on 2017/5/3.
 */
public class ProducerThread extends Thread {

    private DataSet dataSet;

    public ProducerThread(DataSet dataSet){
        this.dataSet = dataSet;
    }

    @Override
    public void run() {

        for(int i=1; i<=dataSet.getMaxNum();i++){
            dataSet.setCurrentNum(i);
            Long factorial = factorial(i);
            dataSet.setFactorialAddition(dataSet.getFactorialAddition() + factorial);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        Long factorialAddition = addition(dataSet.getMaxNum());
//        dataSet.setFactorialAddition(factorialAddition);
    }

    private Long addition(Integer max){
        // 递归最大值为 1 时返回
        if(max == 1){
            return (long)1;
        }
        // 1. 先求最大数的阶乘
        Long factorialResult = factorial(max);

        // 2. 把最大值的阶乘和 （max-1）的阶乘和相加
        Long factorialMax = factorialResult + addition(max -1);
        return factorialMax;

    }

    private Long factorial(Integer max){
        if(max == 1){
            return (long)1;
        }
        return max*factorial(max-1);
    }

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }
}
