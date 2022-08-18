package com.company;

public class IsPall {
    public static void main(String[] args) {
        System.out.println(ispall("asddsa", 0));
    }

    static boolean ispall(String s, int n){

        if (n == s.length()/2){
            return true;
        }
        if (s.charAt(n) == s.charAt(s.length()-1-n)){
            return ispall(s, n+1);
        }
        return false;
    }
}
