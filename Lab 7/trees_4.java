package com.company;

class tree_04{

    treeNode root;

    public tree_04(){
        this.root = null;
    }
    public tree_04(treeNode root){
        this.root = root;
    }

    public void add(treeNode root, treeNode node){

        if(this.root == null){
            this.root = node;
            return;
        }
        if(node.val <= root.val){
            if(root.LEFT == null){
                root.LEFT = node;
                return;
            }
            add(root.LEFT, node);
            return;
        }
        if(node.val > root.val) {
            if (root.RIGHT == null) {
                root.RIGHT = node;
                return;
            }
            add(root.RIGHT, node);
        }
    }

    public void remove(treeNode root, int val){
        if(this.root == null){
            return;
        }
        treeNode curr = root;
        treeNode temp = root;

        while(curr.LEFT != null && curr.RIGHT != null && curr.val != val){

//            if(curr.LEFT.val == val){
//                temp = curr;
//                curr = curr.LEFT;
//                continue;
//            }
            if(curr.val < val){
                temp = curr;
                curr = curr.RIGHT;
            }
            else if(curr.val > val){
                temp = curr;
                curr = curr.LEFT;
            }
        }
        if(curr.LEFT == null || curr.RIGHT == null){
            if(curr.RIGHT == null & curr.LEFT != null){
                if(temp.LEFT == curr){
                    temp.LEFT = curr.LEFT;
                }
                else{
                    temp.RIGHT = curr.LEFT;
                }
            }
            else if(curr.LEFT == null && curr.RIGHT != null){
                if(temp.LEFT == curr){
                    temp.LEFT = curr.RIGHT;
                }
                else{
                    temp.RIGHT = curr.RIGHT;
                }
            }
            else{
                if(temp.LEFT == curr){
                    temp.LEFT = null;
                }
                else{
                    temp.RIGHT = null;
                }
            }
        }
        else{
            find(curr);
        }
    }

    private void find(treeNode root){

        treeNode pre = root;
        treeNode temp1 = root.RIGHT;
        treeNode temp2 = root.LEFT;
        if(root.RIGHT != null){

            while(temp1.LEFT != null){
                pre = temp1;
                temp1 = temp1.LEFT;
            }
            temp1.RIGHT = pre.LEFT;
            root.val = temp1.val;
        }
        else{

            while(temp2.RIGHT != null){
                pre = temp2;
                temp2 = temp2.RIGHT;
            }
            temp2.LEFT = pre.RIGHT;
            root.val = temp2.val;
        }
    }
}
public class trees_4 {
    public static void main(String[] args) {

        treeNode n1 = new treeNode(1);
        treeNode n2 = new treeNode(2);
        treeNode n3 = new treeNode(3);
        treeNode n4 = new treeNode(4);
        treeNode n5 = new treeNode(5);
        treeNode n6 = new treeNode(6);
        treeNode n7 = new treeNode(7);
        treeNode n8 = new treeNode(8);


                                                n5.LEFT=n3;                      n5.RIGHT=n7;
                                    n3.LEFT = n2;   n3.RIGHT=n4;               n7.LEFT=n6;     n7.RIGHT=n8;
                                    n2.LEFT = n1;


        tree_04 t4 = new tree_04(n5);
        t4.remove(n5,5);
    }
}
