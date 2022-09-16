package com.company;


class Node_{

    String data;
    Node_ next;

    public Node_(String data){
        this.data = data;
    }
}

class queue{
    private int size = 0;
    private Node_ rear;
    private Node_ front;

    public queue(){}

    public int length(){
        return size;
    }

    public Node_ Rear(){
        return rear;
    }

    public Node_ Front(){
        return front;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    //  Enqueue element
    public void enqueue(Node_ node){

        if (isEmpty()){
            front = node;
            rear = node;
            size++;
            return;
        }
        rear.next = node;
        rear = node;
        size++;
    }

    //  Deuqeueing element
    public Node_ dequeue(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }

        Node_ ans = front;
        front = front.next;
        size--;
        return ans;
    }
}
public class queue_ {
}


