package com.company;

public class reverse {
    public static void main(String[] args) {
        rev("asdghi",0);
    }

    static void rev(String s, int n){

        if (n == s.length()){
            return;
        }
        rev(s,n+1);
        System.out.print(s.charAt(n));
    }
}