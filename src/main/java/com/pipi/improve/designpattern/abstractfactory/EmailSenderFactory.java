package com.pipi.improve.designpattern.abstractfactory;

/**
 * Created by pipi on 2017/7/2.
 */
public class EmailSenderFactory implements Provider {

    public Sender produce() {
        return new EmailSender();
    }
}
