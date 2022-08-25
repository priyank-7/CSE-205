package com.company;

import java.util.Arrays;

public class InsertElementAtBegining {
    public static void main(String[] args) {
        int[] arr = {32,4,6,3,2,3,46,7,67,4,332,5,6};
        System.out.println(Arrays.toString(insatbeg(arr, 100)));
    }

    static int[] insatbeg(int[] arr, int element){

        int[] arr_ = new int[arr.length+1];
        arr_[0] = element;
        for (int i = 0; i < arr.length; i++) {
            arr_[i+1] = arr[i];
        }
        return arr_;
    }
}
