package com.company;

import java.util.Arrays;

public class insertinArray {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        arr = insatind(arr, 20, 6);
        System.out.println(Arrays.toString(arr));
    }

    static int[] insatind(int [] arr, int index, int element){

        if (index < 1){
            return new int[]{-1};
        }
        else if (index > arr.length){
            int[] newArray = new int[index];
            helper1(arr, newArray,index,element);
            return newArray;
        }
        else {
            int[] newArray = new int[arr.length + 1];
            helper2(arr, newArray, index, element);
            return newArray;
        }
    }

    private static void helper1(int[] arr, int[] newArray, int index, int element) {
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[index-1] = element;
    }

    static void helper2(int[] arr, int[] newArray , int index, int element){
        int count = 1;

        for (int i = 1; i <= newArray.length; i++) {
            if (index == i){
                newArray[index-1] = element;
                count--;
            }
            else {
                newArray[i - 1] = arr[count - 1];
            }
            count++;
        }
    }
}
