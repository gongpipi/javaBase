package com.pipi.improve.collections.stack;

import java.util.Stack;

/**
 * Created by pipi on 2017/7/1.
 */
public class Mystack {
    private Stack<Integer> integerStack;
    private int stack[];
    private int maxLength;
    private int top;

    public Mystack(int maxLength) {
        this.stack = new int[maxLength];
        this.maxLength = maxLength;
        this.top = -1;
    }

    public int pop(){
        int topIndex = top;
        top--;
        return stack[topIndex];
    }

    public boolean push(int value) throws Exception{
        top ++;
        if(top == maxLength){
           throw new Exception("栈已满");
        }else{
            stack[top] = value;
            return true;
        }
    }

    public boolean empty(){
        top = -1;
        return true;
    }
}
