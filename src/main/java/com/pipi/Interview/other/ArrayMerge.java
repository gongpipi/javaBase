package com.pipi.Interview.other;

/**
 * Created by pipi on 2017/7/12.
 * 题目：将两个有序的数组合并为一个有序的数组
 * 思路：
 * 1.分别对两个数组从0开始循环，比较当前的a[i]和b[j]
 * 2.如果a[i]<b[j],则把a[i]放入c数组，并且a数组向前移动一个位置，即i++，否则反之。
 * 3.如果i的大小超出了a数组的大小，则说明a数组已经遍历完，剩下的位置都是b数组的元素，否则反之。
 *
 */
public class ArrayMerge {

    public static void main(String[] args) {
        int a[]={1,3,5,20,30,61,98};
        int b[]={98,99,100};
        int c[]=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(k<c.length){
            if(i>=a.length){
                c[k]=b[j++];
            } else if(j>=b.length){
                c[k]=a[i++];
            }else{
                c[k]=a[i]<=b[j]?a[i++]:b[j++];
            }
            k++;
        }
        for (int ci:c) {
            System.out.print(ci + " ");
        }


    }
}
