package com.pipi.base.thread.exmpale.interview;

/**
 * Created by pipi on 2017/8/21.
 */
public class Nuum {

    private int b = 0;

    public void setb1(){
        b = 1;
    }

    public void setB2(){
        b = 2;
    }

    public void outB(){
        if(b == 0){
            System.out.println("thread 3");
        }
    }
}
