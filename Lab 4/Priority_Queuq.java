package com.company;


class priNode{

    String data;
    priNode next;
    int priority;

    public priNode(String data, int priority){
        this.data = data;
        this.priority = priority;
    }

}

class priority_queue{

    private priNode front;
    private priNode rear;
    private int size;

    public priority_queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if (front == null){
            return true;
        }
        return false;
    }

    //  Enqueue element into the queue
    public void enqueue(String data, int priority){

        priNode node = new priNode(data,priority);
        if (front == null && rear == null){
            node.next = null;
            front = node;
            rear = node;
            size++;
            return;
        }

        if (front.priority > priority){
            node.next = front;
            front = node;
            size++;
            return;
        }

        priNode temp = front;
        while(temp.next != null){
            if (temp.next.priority > priority){
                break;
            }
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    //  dequeuing element as priority
    public priNode dequeue(){
        if (front == null){
            return null;
        }
        priNode temp = front;
        front = front.next;
        size--;
        return temp;
    }

}
public class Priority_Queuq {
}
