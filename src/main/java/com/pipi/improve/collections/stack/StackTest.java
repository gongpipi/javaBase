package com.pipi.improve.collections.stack;

import java.util.Stack;

/**
 * Created by pipi on 2017/7/1.
 */
public class StackTest {

    public static void main(String args []){
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(1);
        integerStack.push(2);
        System.out.println("stack peek is " + integerStack.peek());
    }
}
