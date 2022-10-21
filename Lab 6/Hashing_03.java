package com.company;

import java.util.Arrays;

class Double_hashing{

    int M;
    int P;
    int[] hash_table;

    public Double_hashing(){}
    public Double_hashing(int M, int P){
        this.M = M;
        this.P = P;
        hash_table = new int[M];
    }

    private int hash_function(int val){
        return val%M;
    }

    private int hp(int val){
        return 1 + (val%P);
    }

    public void add(int val){
        int index = hash_function(val);

        if(hash_table[index] == 0){
            hash_table[index] = val;
            return;
        }
        int i = 1;
        int temp = hash_function(index + (i * hp(val)));
        while(hash_table[temp] != 0){
            i++;
            temp = hash_function(index + (i * hp(val)));
        }
        hash_table[temp] = val;
    }

    public boolean find(int val){
        int index = hash_function(val);

        if(hash_table[index] == val){
            return true;
        }
        int i = 1;
        int temp = hash_function(index + (i * hp(val)));
        while(hash_table[temp] != val){
            if (temp == index){
                return false;
            }
            i++;
            temp = hash_function(index + (i * hp(val)));
        }
        return true;
    }

    public void print(){
        System.out.println(Arrays.toString(hash_table));
    }
}

public class Hashing_03 {
    public static void main(String[] args) {
        int [] arr = {133, 88, 92, 221, 174, 133, 133, 174, 174};
        Double_hashing h = new Double_hashing(17,11);
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }
        h.print();
        System.out.println(h.find(100));
        System.out.println(h.find(133));
        System.out.println(h.find(174));

        Double_hashing h1 = new Double_hashing(37,11);
        for (int i = 0; i < arr.length; i++) {
            h1.add(arr[i]);
        }
        h1.print();
        System.out.println(h1.find(100));
        System.out.println(h1.find(133));
        System.out.println(h1.find(174));
    }
}
