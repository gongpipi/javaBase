package com.pipi.fun;

import java.util.Scanner;

/**
 * Created by pipi on 2017/5/3.
 */
public class TestWhileFrequency {
    public static void main(String a[]){
        Long i = (long)0;
        Long before = System.currentTimeMillis();
        System.out.println();
        while (true){
            i = i+ 1;
            if(i == 1000000000){
                break;
            }
        }
        Long after = System.currentTimeMillis();
        // 程序执行的毫秒数
        System.out.println(after - before);
    }
}
