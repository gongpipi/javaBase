package com.pipi.improve.sort.fastsort;

/**
 * 求前k大元素
 * Created by pipi on 2017/7/1.
 */
public class FirstKTest {
    public static void main(String args []){
        int [] origion = {
                1,8,10,14,4,0,34,22,54,99,
                42,36,5,84,13,46,100,78,23,22,
                98,200,56,201,523,485,12,4,6,75,
                12,89,52,46,91,775,446,852,951,423};
        fastsort(origion,0,origion.length-1,5);
        for(int i : origion){
            System.out.print(i +" " );
        }
    }

    public static void fastsort(int [] list, int low, int high,int k){

        // 3.很重要，如果数组长度为1则返回
        if(high - low <= 0){
            return;
        }

        // 1. 获取中间位置
        int middleIndex = getMiddleIndex(list,low,high);
        System.out.println(middleIndex);
        // 2. 依据中间位置，分为两个数组并且分别快排
        if(high - middleIndex >= k){
            // 如果右半部分长度大于k 则只对右半部分排序
            fastsort(list,middleIndex+1,high,k);
        }else{
            // 否则再对左半部分排序
            fastsort(list,low,middleIndex-1,k);
        }
    }

    public static int getMiddleIndex(int [] list, int low, int high){
        int middleValue = list[low];
        int middleIndex = low;
        int tmp = 0;
        for(int i=low;i<= high; i++){
            if(list[i]<middleValue){
                // list[i] 比中间值小，则交换中间值的位置 例如 6,8,2
                tmp = list[i]; // 交换前先保存该值
                list[i] = list[middleIndex+1]; // 把中间值放list[i]的位置
                list[middleIndex+1] = middleValue;
                list[middleIndex] = tmp; // 原来中间值的位置放入list[i]
                middleIndex = middleIndex+1; // 更新中间值的位置
            }
        }
        return middleIndex;
    }
}
