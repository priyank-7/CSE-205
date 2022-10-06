package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Quick_Sort_Random {
    public static void main(String[] args) {

        int [] arr = {23,345,546,435,23,4,345,34,324,23,2,434,434,3,4,3};
        quicksort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quicksort(int [] arr, int low, int high){

        Random r = new Random();

        if (high - low <= 0){
            return;
        }

        int start = low;
        int end = high;
        int pivot = arr[r.nextInt(low,high)];

        while(start <= end){

            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quicksort(arr, low, end);
        quicksort(arr, start, high);

    }
}
