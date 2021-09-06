package com.javarush.task.task26.task2601;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double median;
        int len = array.length;
        Integer[] res =new Integer[len];
        Arrays.sort(array);

        if(len%2 != 0){
            median = array[len/2];
        } else {
            median = (array[(len - 1) / 2] + array[len / 2])/2;
        }
        
        Arrays.sort(array, (o1, o2) -> {
            double v1 = o1 - median;
            double v2 = o2 - median;
            return (int) ((v1 * v1 - v2 * v2) * 100);
        });
        
        return array;
    }
}
