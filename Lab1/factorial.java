package com.company;

public class factorial {
    public static void main(String[] args) {
        double facto = (int)fact(4);
        if(facto == -1){
            System.out.println("Positive Integer Only, please");
        }
        else{
            System.out.println((int)facto);
        }
    }
    static double fact(double n){
        if(n < 0 || n%1 != 0){
            return -1;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        return fact(n-1)*n;
    }
}
