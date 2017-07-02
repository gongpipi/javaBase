package com.pipi.improve.collections.stack;

/**
 * Created by pipi on 2017/7/1.
 */
public class MyStackTest {

    public static void main(String args []) throws Exception{

        Mystack mystack = new Mystack(5);
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        mystack.push(5);
        int topvalue = mystack.pop();
        System.out.println("顶部元素为 " + topvalue);
        mystack.empty();
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        mystack.push(5);
        mystack.push(6);
    }
}
