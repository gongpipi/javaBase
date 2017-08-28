package com.pipi.base.lang;

/**
 * Created by pipi on 2017/8/20.
 */
public class Object {


    public static void main(String[] args) {
        Object ob =new Object();



    }

    void hashcode(){
        Object ob =new Object();
        /**
         * 关于hashcode(),
         * http://docs.oracle.com/javase/8/docs/api/
         * 哈希契约：相同的对象一定有相同的hashcode，但是反过来就不一定。
         * 与hashtable的结构有关
         * 1. 为什么用hashcode，通过hash来在hashmap中查找相同的对象更快
         * */

        System.out.println(ob.hashCode());
    }

    void equal(Object ob){
        // equals()是对两个对象的地址值进行的比较（即比较引用是否相同）。
    }

}
