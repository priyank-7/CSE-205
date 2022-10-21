package com.company;

import java.util.Arrays;

class hashing{

    int M;
    int[] hash_table;

    public hashing(){}
    public hashing(int M){
        this.M = M;
        hash_table = new int[M];
    }

    private int hash_function(int val){
        return val%M;
    }
    public void add(int val){
        int index = hash_function(val);

        if(hash_table[index] == 0){
            hash_table[index] = val;
            return;
        }

        while(hash_table[++index % M] != 0){}

        hash_table[index % M] = val;
    }
    public boolean find(int val){
        int index = hash_function(val);

        if(hash_table[index] == val){
            return true;
        }

        int temp = (index+1) % M;
        while(hash_table[temp] != val){
            if (temp == index){
                return false;
            }
            temp = (temp+1) % M;
        }
        return true;
    }
    public void print(){
        System.out.println(Arrays.toString(hash_table));
    }
}

public class Hashing_01 {
    public static void main(String[] args) {
        int [] arr = {133, 88, 92, 221, 174, 133};
        hashing h = new hashing(17);
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }
        h.print();
        System.out.println(h.find(100));
        System.out.println(h.find(133));
        System.out.println(h.find(174));

        hashing h1 = new hashing(37);
        for (int i = 0; i < arr.length; i++) {
            h1.add(arr[i]);
        }
        h1.print();
        System.out.println(h1.find(100));
        System.out.println(h1.find(133));
        System.out.println(h1.find(174));
    }

}
