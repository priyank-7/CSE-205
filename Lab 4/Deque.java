package com.company;


class dequeNode{

    String data;
    dequeNode next;
    dequeNode pre;

    public dequeNode(){}
    public dequeNode(String val){
        this.data = val;
    }
}


class deque_ {

    private dequeNode front;
    private dequeNode rear;
    private int size;

    public deque_(){
        this.front = null;
        this.rear = null;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if (front == null && rear == null){
            return true;
        }
        return false;
    }

    //  Adding element at the front
    public void pushFront(String data){

        dequeNode node = new dequeNode(data);
        if (front == null){
            node.next = null;
            node.pre = null;
            front = node;
            rear = node;

            size++;
            return;
        }

        node.next = front;
        front.pre = node;
        node.pre = null;
        front = node;
        size++;
    }

    //  Adding element at the rear
    public void pushRear(String data){

        dequeNode node = new dequeNode(data);
        if (rear == null){
            node.next = null;
            node.pre = null;
            front = node;
            rear = node;

            size++;
            return;
        }
        rear.next = node;
        node.pre = rear;
        node.next = null;
        rear = node;
        size++;
    }

    //  Remove element from the front
    public dequeNode popFront() throws Exception{

        if (front == null){
            throw new NullPointerException("Deque is Empty");
        }
        if (front.equals(rear)){
            dequeNode node = front;
            front = null;
            rear = null;
            size--;
            return node;
        }

        dequeNode node = front;
        front = front.next;
        front.pre = null;
        size--;

        return node;
    }

    //  Removing element from the rear
    public dequeNode popRear() throws Exception{

        if (rear == null){
            throw new NullPointerException("Deque is Empty");
        }
        if (front.equals(rear)){
            dequeNode node = front;
            front = null;
            rear = null;
            size--;
            return node;
        }

        dequeNode node = rear;
        rear = rear.pre;
        rear.next = null;
        size--;
        return node;
    }
}
public class Deque {
}
