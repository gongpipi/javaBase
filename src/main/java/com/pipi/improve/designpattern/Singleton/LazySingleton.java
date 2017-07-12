package com.pipi.improve.designpattern.Singleton;

/**
 * Created by pipi on 2017/7/11.
 */
public class LazySingleton {

    private String value;

    private static LazySingleton singleton;

    private LazySingleton(){
        this.value = "mySingleton";
    }

    public static LazySingleton getInstance(){
        if(singleton == null){
            return new LazySingleton();
        }
        return singleton;
    }

}
