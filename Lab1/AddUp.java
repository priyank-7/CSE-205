package com.company;

public class AddUp {
    public static void main(String[] args) {
        System.out.println(addUp_Ite(1.1));
        System.out.println(addUp_Rec(1.1));
    }

    static int addUp_Rec(double n){

        if (n % 1 != 0){
            return -1;
        }

        if (n < 0){
            return -1;
        }

        if (n == 0){
            return 0;
        }
        return (int) n + addUp_Rec(n-1);
    }

    static int addUp_Ite(double n){

        if (n % 1 != 0){
            return -1;
        }

        if (n < 0){
            return -1;
        }
        int sum = 0;
        for (int i = (int)n; i >= 0; i--) {
            sum += i;
        }

        return sum;
    }
}
