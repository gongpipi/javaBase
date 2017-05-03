package com.pipi.base.thread.exmpale.produandconsu;

/**
 * Created by pipi on 2017/5/3.
 */
public class DataSet {

    private Long FactorialAddition;

    private Integer currentNum;
    // 最大数
    private Integer maxNum ;

    public Long getFactorialAddition() {
        return FactorialAddition;
    }

    public void setFactorialAddition(Long factorialAddition) {
        FactorialAddition = factorialAddition;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }
}
