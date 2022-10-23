package com.company;

class Node{
    int data;
    Node next;
    public Node(){}
    public Node(int N){
        this.data  = N;
        this.next = null;
    }
    public Node(int N, Node next){
        this.data  = N;
        this.next = next;
    }

}
class Servers {
    private int M;
    private int re_M;
    Node [] hash_table;
    int [] servers;

    public Servers(){}
    public Servers(int M){
        this.M = M;
        hash_table = new Node[M];
    }

    private int hashing(int val){
        return val % M;
    }

    private int reHashing(int val){
        return val % re_M;
    }

    private boolean contains(int n){
        for (int i = 0; i < servers.length; i++) {
            if(servers[i] == n){
                return true;
            }
        }
        return false;
    }

    public void add(int val) {
        int index = hashing(val);
        if(hash_table[index] == null){
            hash_table[index] = new Node(val);
            return;
        }
        Node temp = hash_table[index];
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void crashed_servers(int [] n){
        this.servers = n;
        this.re_M = M - n.length;
        re_allocation();
    }

    public void re_allocation(){
        for (int i = 0; i < servers.length; i++) {
            if (hash_table[servers[i]] != null) {
                Node temp = hash_table[i];
                while (temp != null) {
                    re_allocate(temp, reHashing(temp.data));
                    temp = temp.next;
                }
                hash_table[servers[i]].next = null;
                hash_table[servers[i]] = null;
            }
        }
    }

    private void re_allocate(Node node, int index){
        if(hash_table[index] == null){
            hash_table[index] = node;
        }
        Node temp = hash_table[index];
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public boolean find(int val){
        if(contains(val)){
            return findNode(val, reHashing(val));
        }
        return findNode(val, hashing(val));
    }

    private boolean findNode(int node, int index){

        Node temp = hash_table[index];
        while(temp != null){
            if(temp.data == node){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
public class Hashing_08 {
    public static void main(String[] args) {
        int [] arr = new int [126];
        for (int i = 0; i < 126; i++) {
            arr[i] = i+1;
        }

        Servers s = new Servers(17);
        for (int i = 0; i < 126; i++) {
            s.add(arr[i]);
        }

        s.crashed_servers(new int[]{1,2,3,4});
        System.out.println(s.find(5));
        System.out.println(s.find(12));
        System.out.println(s.find(126));
        System.out.println(s.find(127));

    }
}
