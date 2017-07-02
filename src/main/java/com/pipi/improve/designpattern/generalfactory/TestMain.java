package com.pipi.improve.designpattern.generalfactory;

/**
 * Created by pipi on 2017/7/2.
 */
public class TestMain {
    public static void main(String args []){

        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produce("email");
        sender.send();
    }
}
