package com.company;


class linkedlist{

    Node head;

    public linkedlist(Node head){
        this.head = head;
    }

    //  6.  Search in Linked List

    public int  lsrch(linkedlist l, int element){

        Node node = l.head;
        int index = 0;
        while (node != null){
            if (node.data == element){
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    //  7.  Insert at the last of the linked list

    public void linsatend(linkedlist l, int element) {

        Node temp = new Node(element);
        if (l.head == null){
            head = temp;
        }

        Node node = l.head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = temp;
        temp.next = null;
    }



    //  8.  Insert element at the beginning of the linked list

    public void lisatbeg(linkedlist l, int element){

        Node temp = new Node(element);
        if (l.head == null){
            l.head = temp;
        }

        temp.next = l.head;
        l.head = temp;
    }

    //  8.  Delete last element of linked list

    public void delatend(linkedlist l){
        if (l.head == null){
            return;
        }
        if (l.head.next == null){
            l.head = null;
            return;
        }
        Node node = l.head;
        while (node.next.next != null){
            node = node.next;
        }
        node.next = null;
    }

    //  10. Replace the element into linked list

    public linkedlist replatind(linkedlist l, int position, int element){
        int count = 1;
        Node node = l.head;

        while (node != null){
            if (count == position){
                node.data = element;
                return l;
            }
            count++;
            node = node.next;
        }
        Node rem = new Node(-1);
        return new linkedlist(rem);
    }


    public void print(linkedlist l) {

        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -->");
            node = node.next;
        }
    }

}
class Node{

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Linked_List_All_Functions {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        linkedlist list = new linkedlist(n1);

        System.out.println(list.lsrch(list,6));

        list.linsatend(list, 55);
        list.print(list);
        System.out.println();

        list.lisatbeg(list, 100);
        list.print(list);
        System.out.println();

        list.delatend(list);
        list.print(list);
        System.out.println();

        linkedlist list1 = list.replatind(list, 6,1000);
        list.print(list1);
        System.out.println();

    }
}
