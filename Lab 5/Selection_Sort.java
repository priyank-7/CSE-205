package com.company;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {

        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        double start =  System.nanoTime();
        selectionSort(arr);
        double end =  System.nanoTime();
        System.out.println(Arrays.toString(arr));
        System.out.println(end - start+" Nano second");

        //  Best case = 6500 Nano second
        //  Worst case = 7100 Nano second
    }

    static void selectionSort(int [] arr){

        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
            min = i+1;
        }
    }

    static void swap(int [] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
