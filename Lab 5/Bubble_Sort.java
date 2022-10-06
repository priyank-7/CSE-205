package com.company;

import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6,23,34,2,1,2,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int [] arr){

        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j-1] > arr[j]){
                    flag = false;
                    swap(arr,j-1,j);
                }
            }
            if (flag){
                break;
            }
        }
    }

    static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
