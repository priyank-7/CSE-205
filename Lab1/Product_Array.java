package com.company;

public class Product_Array {
    public static void main(String[] args) {

        int [] arr = {3,4,5};
        System.out.println(prodArray(arr, arr.length-1));
    }

    static int prodArray(int [] arr, int n) {

        if (n < 0) {
            return 1;
        }
        return arr[n] * prodArray(arr, n - 1);
    }
}
