package com.company;

import java.util.Arrays;

class hashing_2D{

    int M;
    int[][] hash_table;

    public hashing_2D(){}
    public hashing_2D(int M){
        this.M = M;
        hash_table = new int[M][10];
    }

    private int hash_function(int val){
        return val%M;
    }
    public void add(int val){
        int index = hash_function(val);

        for (int i = 0; i < hash_table[0].length; i++) {
            if(hash_table[index][i] == 0){
                hash_table[index][i] = val;
                return;
            }
        }
    }
    public boolean find(int val){
        int index = hash_function(val);

        for (int i = 0; i < hash_table[0].length; i++) {
            if(hash_table[index][i] == val){
                return true;
            }
        }
        return false;
    }
    public void print(){
        for (int [] arr : hash_table) {
            System.out.println(Arrays.toString(arr));
        }
    }
}


public class Hashing_07 {
    public static void main(String[] args) {
        int [] arr = {133, 88, 92, 221, 174, 133, 133, 174, 174};
        hashing_2D h = new hashing_2D(17);
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }
        h.print();
        System.out.println(h.find(100));
        System.out.println(h.find(133));
        System.out.println(h.find(174));

        hashing_2D h1 = new hashing_2D(37);
        for (int i = 0; i < arr.length; i++) {
            h1.add(arr[i]);
        }
        h1.print();
        System.out.println(h1.find(100));
        System.out.println(h1.find(133));
        System.out.println(h1.find(174));
    }
}
