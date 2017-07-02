package com.pipi.improve.designpattern.generalfactory;

/**
 * Created by pipi on 2017/7/2.
 */
public class SenderFactory {

    // 普通工厂类模式
    public Sender produce(String type){
        if(type == "sms"){
            return new SmsSender();
        }else if(type == "email"){
            return new EmailSender();
        }else{
            System.out.println("请输入正确的类型");
        }
        return null;
    }

    // 多个工厂方法模式
    public Sender produceEmail(){
        return new EmailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }

    // 静态工厂类模式
    public static Sender produceMail(){
        return new EmailSender();
    }

    public static Sender produceSms1(){
        return new SmsSender();
    }

}
