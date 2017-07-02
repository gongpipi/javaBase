package com.pipi.improve.designpattern.abstractfactory;

/**
 * Created by pipi on 2017/7/2.
 */
public class SmsSenderFactory implements Provider {

    public Sender produce() {
        return new SmsSender();
    }
}
