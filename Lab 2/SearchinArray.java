package com.company;

import java.util.Arrays;

public class SearchinArray {
    public static void main(String[] args) {

        int[] arr = {1,4,3,2};
        System.out.println(Arrays.toString(arr));
        System.out.println(srch(arr,5));
    }

    static int srch(int [] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i+1;
            }
        }
        return -1;
    }
}
