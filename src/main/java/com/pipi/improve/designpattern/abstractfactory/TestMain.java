package com.pipi.improve.designpattern.abstractfactory;

/**
 * Created by pipi on 2017/7/2.
 */
public class TestMain {

    public static void main(String args []){

        Provider provider = new EmailSenderFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}



