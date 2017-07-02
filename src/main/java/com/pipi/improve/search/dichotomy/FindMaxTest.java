package com.pipi.improve.search.dichotomy;

/**
 * Created by pipi on 2017/7/1.
 */
public class FindMaxTest {

    public static void main(String args []){
        int [] origion = {1,8,10,14,4,0,34,22,54,99,42,36,5,84,13,46,100,78,23,22,98,200,56};

        System.out.println("最大值为 " + maxElem(origion,0,origion.length));
    }

    public static int maxElem(int [] origin, int low, int high){
        int middleIndex = (high - low)/2;
        if(middleIndex == 0){
            return origin[low];
        }
        int leftMax = maxElem(origin,low,low + middleIndex);
        int rightMax = maxElem(origin,low + middleIndex,high);
        System.out.println("left " + leftMax + " ringht " + rightMax);
        if(leftMax > rightMax){
            return leftMax;
        }else{
            return rightMax;
        }
    };
}
