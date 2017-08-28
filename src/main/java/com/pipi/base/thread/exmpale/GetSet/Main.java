package com.pipi.base.thread.exmpale.GetSet;

/**
 * Created by pipi on 2017/8/20.
 */
public class Main {

    public static void main(String[] args) {
        CubbyHole hole = new CubbyHole();
        new Producer(hole).start();
        new Customer(hole).start();
    }
}

