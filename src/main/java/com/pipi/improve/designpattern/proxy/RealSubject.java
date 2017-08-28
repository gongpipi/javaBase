package com.pipi.improve.designpattern.proxy;

/**
 * Created by pipi on 2017/8/27.
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println( "call doSomething()" );
    }
}
