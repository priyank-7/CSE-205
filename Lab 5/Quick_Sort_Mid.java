package com.company;

import java.util.Arrays;

public class Quick_Sort_Mid {
    public static void main(String[] args) {
        int [] arr = {4,5,1,2,3};
        quickSort_(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort_(int [] arr, int low, int high){

        if (low >= high){
            return;
        }

        int start = low;
        int end = high;
        int mid = (start + end)/2;
        int  pivot = arr[mid];


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

        quickSort_(arr, low, end);
        quickSort_(arr, start, high);

    }

}
