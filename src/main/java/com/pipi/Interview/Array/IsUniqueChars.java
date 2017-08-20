package com.pipi.Interview.Array;

/**
 * Created by pipi on 2017/7/26.
 * 问题：实现一个算法，判断字符串中没有重复的字符，首先字符都是小写。而且不用其他任何的数据结构，包括数组
 * 实现：利用int类型的大小，总共31位（符号位不算），每一位代表不同的字母，则可以表示31个不同的字符。
 * 假如前k个字母都不相同，则int类型的二进制表示可能为000011，假设第k+1个数为00100，则其与前k个数的和的按位与的值为0，
 * 第k个字符如果重复，假如是010，与运算结果为010，说明重复
 */
public class IsUniqueChars {

    public boolean isUniqueChars(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
//            System.out.println(val);
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
            System.out.println((1 << 25) + 1);
//            System.out.println(checker);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsUniqueChars().isUniqueChars("a!"));
    }
}
