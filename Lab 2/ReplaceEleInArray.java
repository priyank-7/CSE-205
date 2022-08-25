package com.company;

import java.util.Arrays;

public class ReplaceEleInArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(replatid(arr,3,10)));
    }

    public static int[] replatid(int[] arr, int position, int element){

        if (position < 1 || position > arr.length){
            return arr;
        }
        arr[position-1] = element;
        return arr;
    }
}
