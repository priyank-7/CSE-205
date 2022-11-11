package com.company;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


class treeNode_01{
    int val;
    treeNode_01 LEFT;
    treeNode_01 RIGHT;

    public treeNode_01(){
        val = 0;
        LEFT = null;
        RIGHT = null;
    }
    public treeNode_01(int val){
        this.val = val;
        LEFT = null;
        RIGHT = null;
    }
}

class tree_01{

    treeNode_01 root;

    public tree_01(){}
    public tree_01(treeNode_01 root){
        this.root = root;
    }

    public void pre_Order(){
        Stack<treeNode_01> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            treeNode_01 temp = st.pop();
            System.out.print(temp.val);

            if(temp.RIGHT != null){
                st.push(temp.RIGHT);
            }
            if(temp.LEFT != null){
                st.push(temp.LEFT);
            }
        }
    }

    public void in_Order(){
        Stack<treeNode_01> st = new Stack<>();
//        st.push(root);
        treeNode_01 curr = root;
        while(!st.isEmpty() || curr != null){
            if(curr != null){
                st.push(curr);
                curr = curr.LEFT;
            }
            else{
                curr = st.pop();
                System.out.print(curr.val);
                curr = curr.RIGHT;
            }
        }
    }

    public void post_Order(){
        Stack<treeNode_01> st = new Stack<>();

    }
}
public class trees_1 {
    public static void main(String[] args) {

                                            treeNode_01 n1 = new treeNode_01(1);
                                            treeNode_01 n2 = new treeNode_01(2);
                                            treeNode_01 n3 = new treeNode_01(3);
                                            treeNode_01 n4 = new treeNode_01(4);
                                            treeNode_01 n5 = new treeNode_01(5);
                                            treeNode_01 n6 = new treeNode_01(6);
                                            treeNode_01 n7 = new treeNode_01(7);
                                            treeNode_01 n8 = new treeNode_01(8);

                                                        tree_01 t = new tree_01(n1);
                                            n1.LEFT = n2;                           n1.RIGHT=n3;
                                    n2.LEFT=n4;       n2.RIGHT=n5;            n3.LEFT=n6;    n3.RIGHT=n7;
                               n4.LEFT=n8;
        t.pre_Order();
        System.out.println();
        t.in_Order();
        System.out.println();
        t.post_Order();

    }
}
