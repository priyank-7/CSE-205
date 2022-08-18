package com.company;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib_Recursive(5));
        System.out.println(fib_Iterative(5));
    }

    static int fib_Recursive(int n){

        if (n != Math.floor(n)){
            return -1;
        }
        if (n <= 0){
            return -1;
        }
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return fib_Recursive(n-1)+fib_Recursive(n-2);
    }

    static int fib_Iterative(int n) {

        if (n != Math.floor(n)){
            return -1;
        }
        if (n <= 0){
            return -1;
        }
        if (n == 1){
            return 0;
        }

        int a = 0;
        int b = 1;
        int sum = 0;

        for (int i = 3; i <= n; i++) {

            sum = a+b;
            a = b;
            b = sum;
        }
        return b;
    }
}
