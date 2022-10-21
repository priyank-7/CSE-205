package com.company;

import java.util.Arrays;

class two_hash_table{

    int M1;
    int M2;
    byte [] hash_table_1;
    byte [] hash_table_2;

    public two_hash_table(){}
    public two_hash_table(int M1, int M2){
        this.M1 = M1;
        this.M2 = M2;
        hash_table_1 = new byte[M1];
        hash_table_2 = new byte[M2];
    }

    private int hash_fun_1(int val){
        return val % M1;
    }
    private int hash_fun_2(int val){
        return val % M2;
    }

    public void add(int val){
        hash_table_1[hash_fun_1(val)] = 1;
        hash_table_2[hash_fun_2(val)] = 1;
    }

//        int temp1 = (index+1) % M1;
//        int temp2 = (index+1) % M2;
//
//        while(hash_table_1[temp1] != 0){
//            temp1 = (temp1+1) % M1;
//            temp2 = (temp2+1) % M2;
//        }
//
//        hash_table_1[temp1] = 1;
//        hash_table_1[temp2] = 1;

    public boolean find(int val){
        return hash_table_1[hash_fun_1(val)] == 1 && hash_table_2[hash_fun_2(val)] == 1;
    }

    public void print(){
        System.out.println(Arrays.toString(hash_table_1));
        System.out.println(Arrays.toString(hash_table_2));
    }
}
public class Hashing_04 {
    public static void main(String[] args) {
        int [] arr = {133, 88, 92, 221, 174, 133, 133, 174, 174};
        two_hash_table h = new two_hash_table(17,37);
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }
        h.print();
        System.out.println(h.find(100));
        System.out.println(h.find(133));
        System.out.println(h.find(174));

//        Double_hashing h1 = new Double_hashing(37,11);
//        for (int i = 0; i < arr.length; i++) {
//            h1.add(arr[i]);
//        }
//        h1.print();
//        System.out.println(h1.find(100));
//        System.out.println(h1.find(133));
//        System.out.println(h1.find(174));
    }
}
