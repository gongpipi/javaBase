package com.pipi.Interview.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pipi on 2017/7/12.
 * 问题：实现字符串反转
 * 思路：
 * 1.先把字符串转化为字符数组
 * 2.求得中间位置
 * 3.对两边元素分别进行对换，细节处理，
 * 如果数组长度为单数，则从数组的floor(length/2)处，两边两两对换，总共循环length/2次
 * 如果数组长度为双数，则从数组的length/2-1和length/2处，两两对换,总共循环length/2次
 */
public class ReversalString {

    /**
     * Reversal string.
     * 我的方法，是从中间开始交换
     * @param original the original
     * @return the string
     */
    public String reversal(String original) {
        char c;
        char[] ori = original.toCharArray();
        int length = ori.length;

        int cycleTimes = ori.length / 2;
        while (cycleTimes > 0) {
            c = ori[length - cycleTimes];
            ori[length - cycleTimes] = ori[cycleTimes - 1];
            ori[cycleTimes - 1] = c;
            cycleTimes--;
        }
        return new String(ori);
    }


    /**
     * Swap.
     * 网友的方法，从两边交换
     *
     * @param arr   the arr
     * @param begin the begin
     * @param end   the end
     */
    public String swap(char[] arr, int begin, int end) {
        while(begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
        return new String(arr);
    }

    public String swap(String ori){
        return new StringBuffer(ori).reverse().toString();
    }

    public String collectionsSwap(String ari){
        char [] charArr = ari.toCharArray();
        List integerList = Arrays.asList(charArr);
//        List<Character> integerList2 = Arrays.asList(charArr);
//       报错 见链接 http://www.cnblogs.com/happyPawpaw/archive/2012/10/22/2734140.html
        // 问题int[] 转interger[]

        Collections.reverse(integerList);
        Character characters[] = (Character[]) integerList.toArray();
        String des = "";
        for(Character cha : characters){
            des = "" + cha.charValue();
        }
        return des;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String hello = "hello world1";
        System.out.println(new ReversalString().reversal(hello));
        System.out.println(new ReversalString().swap(hello.toCharArray(),0,hello.toCharArray().length-1));
        System.out.println(new ReversalString().swap(hello));
        System.out.println(new ReversalString().collectionsSwap(hello));
    }
}
