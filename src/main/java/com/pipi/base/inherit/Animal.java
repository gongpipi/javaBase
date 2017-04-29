package com.pipi.base.inherit;

/**
 * Created by pipi on 2017/4/28.
 */
public class Animal {
    private int legNum;
    private String food;

    public Animal(){

    }
    public Animal(int legNum, String food) {
        this.legNum = legNum;
        this.food = food;
    }
    public void display(){
        System.out.println("Animal legNum is" + legNum +" food is :"+food);
    }
}

