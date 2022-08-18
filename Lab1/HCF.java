package com.company;

public class HCF {
    public static void main(String[] args) {
        System.out.println(GCD(15,24));
        System.out.println(GCD(24,15));
    }

    //  long_divisor

    static int GCD(int a, int b){
        if (a==0){
            return b;
        }
        return GCD((b%a),a);
    }

    //  Other Method

    static int gcd_1(int a, int b){
        if (a == b){
            return a;
        }
        if (a>b){
            a -= b;
        }
        else if (b > a){
            b -= a;
        }
        return gcd_1(a,b);
    }
}
