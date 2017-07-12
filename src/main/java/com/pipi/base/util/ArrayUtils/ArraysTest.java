package com.pipi.base.util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by pipi on 2017/7/12.
 */
public class ArraysTest {

    public static void main(String[] args) {
        Integer [] integers = {1,9,34,23,15,63,72,16,3,5,86,46,35,21,1,2,3,45,8,75,48,25};
        //
        Arrays.sort(integers, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(Integer i : integers){
            System.out.print(i + " ");
        }
        System.out.println();

        int index = Arrays.binarySearch(integers,86);
        System.out.println(index);

        // 排序后比较得到的结果，两个数组比较，必须每一位都相等
        Integer [] integers2 = {1, 1, 2, 3, 3, 5 ,8, 9, 15, 16, 21,
                23, 25 ,34, 35, 45, 46, 48, 63, 72, 75, 86 };
        System.out.println(Arrays.equals(integers,integers2));
    }
}
