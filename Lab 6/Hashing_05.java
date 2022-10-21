package com.company;

import java.util.Arrays;

class polynomial_hashing{
    private int M;
    private int a;
    String [] hash_table;

    public polynomial_hashing(){}
    public polynomial_hashing(int M){
        this.M = M;
        hash_table = new String[M];
    }

    private int hash_function(int val){
        System.out.println(val % M);
        return val % M;
    }

    private int polynomial_function(String s){
        this.a = s.length();
        int val = 0;
        for (int i = a-1; i >= 0; i--) {
            val += s.charAt(a-i-1) * (int)Math.pow(a,i);
        }
        System.out.println(s+" "+val);
        return hash_function(val);
    }

    public void add(String s){
        int index = polynomial_function(s);
        if(hash_table[index] == null){
            hash_table[index] = s;
            return;
        }
        int temp = (index+1) % M;
        while (hash_table[temp] != null){
            temp = (temp+1) % M;
        }
        hash_table[index] = s;
    }

    public boolean find(String s){
        int index = polynomial_function(s);
        if(hash_table[index].equals(s)){
            return true;
        }
        int temp = (index+1) % M;
        while(temp != index){
            if(hash_table[index].equals(s)){
                return true;
            }
        }
        return false;
    }

    public void print(){
        System.out.println(Arrays.toString(hash_table));
    }


}
public class Hashing_05 {
    public static void main(String[] args) {
        String [] arr = {"fist", "sift", "shift", "fast", "faster", "shaft"};
        polynomial_hashing h = new polynomial_hashing(17);
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }
        h.print();

    }
}
