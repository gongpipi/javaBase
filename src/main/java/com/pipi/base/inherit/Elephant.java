package com.pipi.base.inherit;

/**
 * Created by pipi on 2017/4/28.
 */
public class Elephant extends Animal {
    private int weight;
    private int ageMax;
    public Elephant(){
    }

    public Elephant(String food){
//        super(0,food);
    }

    public Elephant(int legNum,String food,int weight,int ageMax){
//        super(legNum,food);
        this.ageMax= ageMax;
        this.weight = weight;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Elephant weight is:"+weight + "ageMax :" + ageMax);
    }

    public static void main(String args[]){
        Elephant elephant = new Elephant("banana");
        elephant.display();
        elephant = new Elephant(4,"grass",1000,20);
        elephant.display();

        // 注意 父类是可以指向子类的
        Animal animal = new Elephant("APPLE");
        animal.display();
        animal = new Elephant(4,"leaf",2000,30);
        animal.display();
        /* 输出 四次display

        Animal legNum is0 food is :banana
        Elephant weight is:0ageMax :0

        Animal legNum is4 food is :grass
        Elephant weight is:1000ageMax :20

        Animal legNum is0 food is :APPLE
        Elephant weight is:0ageMax :0

        Animal legNum is4 food is :leaf
        Elephant weight is:2000ageMax :30

         */
    }
}
