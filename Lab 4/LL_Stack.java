package com.company;

class Node{
    String val;
    Node next;

    public Node(String val){
        this.val = val;
    }
}

class stack {

    private Node head;
    private int size;

    public stack() {
    }

    public stack(Node head) {
        this.head = head;
    }


    public int length() {
        return size;
    }


    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }


    //  Put new element as peek
    public void push(Node node) {

        if (head == null) {
            this.head = node;
            head.next = null;
            size++;
            return;
        }
        node.next = head;
        this.head = node;
        size++;
    }


    //  Pop out the peek element
    public Node pop() {

        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        }
        Node temp = head;
        this.head = head.next;
        size--;
        return temp;
    }


    //  Return the peek element
    public Node peek() {

        if (head == null) {
            System.out.println("The stack is Empty");
            return null;
        }
        return head;
    }


    //  Check for  balanced parentheses, bracket and braces
    public boolean isBalenced(String s){

        stack st = new stack();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if ( c== '(' || c == '[' || c == '{'){
                st.push(new Node(String.valueOf(c)));
                continue;
            }
            if (c == '/' &&  s.charAt(i) == c){
                break;
            }
            else if (Character.isAlphabetic(c)){
                continue;
            }
            else if (c == ' '){
                continue;
            }
            if (st.isEmpty()){
                return false;
            }
            switch (c){
                case ')':
                    if (st.peek().val.charAt(0) == '{' || st.peek().val.charAt(0) == '['){
                        return false;
                    }
                    st.pop();
                    break;
                    case ']':
                    if (st.peek().val.charAt(0) == '{' || st.peek().val.charAt(0) == '('){
                        return false;
                    }
                    st.pop();
                    break;
                    case '}':
                    if (st.peek().val.charAt(0) == '(' || st.peek().val.charAt(0) == '['){
                        return false;
                    }
                    st.pop();
                    break;
            }
        }
        return st.isEmpty();
    }

    //  Post-fix Expression
    public void post_fix(String s){

        stack st = new stack();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' '){
                continue;
            }
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ' '){
                st.push(new Node(String.valueOf(c)));
            }
            else if (Character.isDigit(c)){
                System.out.print(c);
            }
            else{
                String ch = st.pop().val;
                while(!ch.equals("(")){
                    System.out.print(ch);
                    ch = st.pop().val;
                }
            }
        }
        if(!st.isEmpty()){
            String ch= st.pop().val;
            while(!isEmpty()) {
                if (!ch.equals("(")) {
                    System.out.print(ch);
                    if (st.isEmpty()){
                        break;
                    }
                    ch = st.pop().val;
                }
            }
        }
    }
}

public class LL_Stack {
}
