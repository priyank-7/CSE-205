package com.company;

import java.util.Arrays;

public class Mearge_Sort {
    public static void main(String[] args) {

        int [] arr = {4,6,1,8,3,6,2,5};    // 23,345,546,435,23,4,345,34,324,23,2,434,434,3,4,3
//        mergeSort(arr,0, arr.length-1);
        mergeSort1(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr, int start, int end){

        if(start > end){
            return;
        }
        if (end - start == 0){
//            mergeArray(arr, start, start, end);
            return;
        }

        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        mergeArray(arr,start, mid, end);
    }

    static void mergeArray(int [] arr, int start,int mid,  int end){

        int [] temp = new int [end - start + 1];

        int first = start;
        int second = mid+1;
        int index = 0;

        while(first <= mid && second <= end){

            if(arr[first] <= arr[second]){
                temp[index] = arr[first];
                first++;
                index++;
            }
            if(arr[second] < arr[first]){
                temp[index] = arr[second];
                second++;
                index++;
            }
        }

        while(first <= mid){
            temp[index] = arr[first];
            first++;
            index++;
        }
        while(second <= end){
            temp[index] = arr[second];
            second++;
            index++;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }

    public static void mergeSort1(int [] arr, int start, int end){

        if(start > end){
            return;
        }
        if (end - start == 0){
            return;
        }

        int mid = (start+end)/2;
        mergeSort1(arr, start, mid);
        mergeSort1(arr, mid+1, end);

        mergeArray1(arr,start, mid, end);

    }

    static void mergeArray1(int [] arr, int start,int mid,  int end){

        int first = start;
        int second = mid+1;
        int index = second;

        while(first <= mid && second <= end){

            if(arr[second] <= arr[first]){
               second++;
               continue;
            }
            else if(arr[first] < arr[second]){
                first++;
                continue;
            }
            while(index < second){
                int temp = arr[first];
                arr[first] = arr[index];
                arr[index] = temp;
                first++;
                index++;
            }




//            if(arr[second] < arr[first]){
//                int temp = arr[first];
//                arr[first] = arr[second];
//                arr[second] = temp;
//                first++;
////                second++;
//            }
        }

//        while(first <= mid){
//
//            first++;
//            index++;
//        }
//        while(second <= end){
//            second++;
//            index++;
//        }

//        for (int i = 0; i < temp.length; i++) {
//            arr[start + i] = temp[i];
//        }

    }
}
