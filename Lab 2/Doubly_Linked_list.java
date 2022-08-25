package com.company;

class Doublyll{
    Node_ head;

    public Doublyll(Node_ head) {
        this.head = head;
    }

    //  11. append an element into the doubly linked list.

    public void dubbly_append(Doublyll l, int element){

        Node_ temp = new Node_(element);
        if (l.head == null){
            temp.pre = null;
            temp.next = null;
            l.head = temp;
        }
        Node_ node = l.head;

        while (node.next != null){
            node = node.next;
        }
        node.next = temp;
        temp.pre = node;
        temp.next = null;
    }

    //  12.  remove an element from the doubly linked list.

    public void dubbly_remove(Doublyll l, int element){

        Node_ node = l.head;
        if (node.val == element){
            l.head = node.next;
            node.next.pre = null;
            return;
        }

        while (node.next != null){
            if (node.val == element){
                node.pre.next = node.next;
                node.next.pre = node.pre;
                return;
            }
            node = node.next;
        }
        node.pre.next = null;
    }

    public void print(Doublyll l) {

        Node_ node = l.head;
        while (node != null) {
            System.out.print(node.val + " <-->");
            node = node.next;
        }
    }
}

class Node_{

    int val;
    Node_ next;
    Node_ pre;

    public Node_(int val) {
        this.val = val;
    }

    public Node_(int val, Node_ next, Node_ pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}
public class Doubly_Linked_list {
    public static void main(String[] args) {

        Node_ n1 = new Node_(1);
        Node_ n2 = new Node_(6);
        Node_ n3 = new Node_(22);
        Node_ n4 = new Node_(3);

        n1.next = n2;
        n1.pre = null;
        n2.next = n3;
        n2.pre = n1;
        n3.next = n4;
        n3.pre = n2;
        n4.next = null;
        n4.pre = n3;

        Doublyll l = new Doublyll(n1);

        l.dubbly_append(l, 6);
        l.print(l);
        System.out.println();

        l.dubbly_remove(l, 22);
        l.print(l);

    }
}
