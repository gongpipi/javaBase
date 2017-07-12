package com.pipi.Interview.baidu.sumcombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pipi on 2017/7/10.
 */
public class SumCouple {

    public static void main(String args []){

        Integer [] array = {1,2,3,4,5,6,7,8,9,12,14,15,24,25,26,29,30,31,35,36};
        List<Integer> integers = java.util.Arrays.asList(array);
        HashMap<Integer,Integer> reseult = new HashMap<Integer, Integer>();
        int x,y,m=30;
        for(int i=0;i<=array.length/2;i++){
            x = array[i];
            y = m -x;
            if(integers.contains(y)){
                reseult.put(x,y);
            };
        }

        for(Integer i : reseult.keySet()){
            System.out.println("("+ i + "," +reseult.get(i)+ ")");
        }
    }
}
