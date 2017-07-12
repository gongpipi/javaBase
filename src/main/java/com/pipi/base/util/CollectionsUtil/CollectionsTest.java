package com.pipi.base.util.CollectionsUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gongshaobo on 2017/7/12  17:41.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        Integer [] integers = {1,9,34,23,15,63,72,16,3,5,86,46,35,21,1,2,3,45,8,75,48,25};
        List<Integer> integerList = Arrays.asList(integers);
        // comparator为排序方式 此处为降序
        Collections.sort(integerList,new Comparator<Integer>(){
            public int compare(Integer arg0, Integer arg1) {
                return arg1.compareTo(arg0);
            }
        });
        for(Integer i : integerList){
            System.out.print(i + " ");
        }
        // -1位升序，1和0为升序
        Arrays.sort(integers, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -1;
            }
        });

        for(Integer i : integers){
            System.out.print(i + " ");
        }


    }
}
