package com.pipi.improve.designpattern.proxy;

/**
 * Created by pipi on 2017/8/27.
 */
public class TestProxy {

    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        Subject subject =  (Subject) proxyHandler.bind(new RealSubject());

        subject.doSomething();
    }
}
