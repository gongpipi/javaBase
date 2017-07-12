package com.pipi.base.util;

/**
 * Created by gongshaobo on 2017/7/12  15:42.
 */
public class MathUtilTest {

    public static void main(String args []){

        // 向上取整
        int ceil = (int) Math.ceil(1.2);
        System.out.println(ceil);
        // 向下取整
        System.out.println(Math.floor(1.2));
        // 四舍五入
        System.out.println(Math.round(1.5));
        // 正负号函数
        System.out.println(Math.signum(23));
        // 随机数
        System.out.println(Math.random());
        // 平方根
        System.out.println(Math.sqrt(25));
        // 返回ascii
        int a = ' ';
        System.out.println(a);
    }
}
