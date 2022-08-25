package com.company;

import java.util.Arrays;

public class InsertElementAtEnd {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9};
        System.out.println(Arrays.toString(insatend(arr, 55)));
    }

    static int[]  insatend(int[] arr, int element){

        int[] arr_ = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            arr_[i] = arr[i];
        }
        arr_[arr_.length-1] = element;
        return arr_;
    }
}
