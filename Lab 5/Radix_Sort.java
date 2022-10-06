package com.company;

import java.util.Arrays;

class radixNode{

    int val;
    radixNode next;

    public radixNode(){}
    public radixNode(int val){
        this.val = val;
        this.next = null;
    }
}

class radixQueue{

    radixNode [] arr = new radixNode[10];

    int size = 0;
    public radixQueue(){}

    public void enqueue(int value, int pos){

        radixNode node = new radixNode(value);

        if(arr[pos] == null){
            arr[pos] = node;
            size++;
            return;
        }

        radixNode temp = arr[pos];
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public int dequeue(){

        for (int i = 0; i < 10; i++) {
            if(arr[i] != null){
                radixNode temp = arr[i];
                arr[i] = arr[i].next;
                return temp.val;
            }
        }
        return Integer.MAX_VALUE;
    }
}
public class Radix_Sort {
    public static void main(String[] args) {

        int [] arr = {23,345,546,435,23,4,345,34,324,23,2,434,434,3,4,3};
        radixSort(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    static void radixSort(int [] arr, int max_digit){

        radixQueue rq = new radixQueue();

        for (int i = 1; i <= max_digit; i++) {
            int n =  (int) Math.pow(10,i);
            for (int j = 0; j < arr.length; j++) {
                rq.enqueue(arr[j], (arr[j]%n)/(n/10));
            }
            for (int k = 0; k < arr.length; k++) {
                arr[k] = rq.dequeue();
            }
        }
    }
}
