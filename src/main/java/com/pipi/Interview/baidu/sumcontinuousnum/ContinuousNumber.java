package com.pipi.Interview.baidu.sumcontinuousnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pipi on 2017/7/10.
 */
public class ContinuousNumber {

    public static void main(String args []){

        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer,Integer> resultMap = new HashMap<Integer, Integer>();

        int n = 55;
        for(int k=2; k*k< 2*n; k++){
            if((2*n + k*(1-k))%(2*k) == 0){
                int x = (2*n + k*(1-k))/(2*k);
                resultMap.put(x,k);
            }
        }

        for(Integer i : resultMap.keySet()){
            System.out.println("起始值"+ i + ", 共" +resultMap.get(i)+ "个数");
        }
    }
}
