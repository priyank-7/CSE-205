package com.company;

import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {

        int [] arr = {0,1,2,3,4,5,6,7,8,9};
        double start =  System.nanoTime();
        insertionsort_2(arr);
        double end =  System.nanoTime();
        System.out.println(Arrays.toString(arr));
        System.out.println(end - start);

        //  Best case = 8000 Nano second        ----> Binary Search Method
        //  Worst case = 8500 Nano second       ----> Binary Search Method

        //  Best case = 2500 Nano second       ----> Linear Search Method
        //  Worst case = 6000 Nano second       ----> Linear Search Method
    }

    static void insertionSort(int [] arr){

        for (int i = 1; i < arr.length; i++) {
            int index = binarySearch(arr,0, i-1, arr[i]);
            int temp = arr[i];
            swap(arr, index, i);
            arr[index] = temp;

        }
    }

    static int binarySearch(int [] arr, int start, int end, int target){

        while (start <= end){

            int mid = start+(end-start)/2;

            if (target < arr[mid]){
                end = mid - 1;
            }
            else if (target > arr[mid]){
                start = mid + 1;
            }
            else{
                if (arr[mid] == target){
                    start = mid+1;
                }
            }
        }
        return start;
    }

    static void swap(int [] arr, int i, int j){

        for (int k = j; k > i; k--) {
            arr[k] = arr[k-1];
        }
    }

    static void insertionsort_2(int [] arr){

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else{
                    break;
                }
            }
        }
    }

//    static void swap_(int [] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}
