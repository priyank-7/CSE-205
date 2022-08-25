package com.company;

import java.util.Arrays;

public class DeleteinArray {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        delatind(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    static void delatind(int[] arr, int index){

        if (index < 1 || index > arr.length){
            return;
        }

        for (int i = 1; i <= arr.length; i++) {
            if (i == index){
                for (int j = i-1; j < arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = 0;
                break;
            }
        }
    }
}