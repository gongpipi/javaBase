package com.pipi.improve.designpattern.abstractfactory;

/**
 * Created by pipi on 2017/7/2.
 */
public class EmailSender implements Sender {

    public void send() {
        System.out.println("this is email");
    }
}
