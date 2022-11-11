package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Gen_TreeNode{
    int data;
    Gen_TreeNode[] children;

    public Gen_TreeNode(int data, int size){
        this.data = data;
        this.children = new Gen_TreeNode[size];
    }
}

class tree_02{
    Gen_TreeNode root;

    public tree_02(Gen_TreeNode root){
        this.root = root;
    }

    public boolean BFS(int target) {

        if (root.data == target) {
            return true;
        }

        Queue<Gen_TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Gen_TreeNode n = q.poll();
            if (n.data == target) {
                return true;
            }
            int c = n.children.length;
            int i = 0;
            while (c-- > 0) {
                if (n.children[i] != null) {
                    q.add(n.children[i]);
                }
                i++;
            }
        }
        return false;
    }
}

public class trees_2 {
    public static void main(String[] args) {

        Gen_TreeNode n1 = new Gen_TreeNode(5,3);
        Gen_TreeNode n2 = new Gen_TreeNode(1,1);
        Gen_TreeNode n3 = new Gen_TreeNode(2,2);
        Gen_TreeNode n4 = new Gen_TreeNode(3,3);
        Gen_TreeNode n5 = new Gen_TreeNode(3,0);
        Gen_TreeNode n6 = new Gen_TreeNode(6,0);
        Gen_TreeNode n7 = new Gen_TreeNode(7,0);
        Gen_TreeNode n8 = new Gen_TreeNode(7,0);
        Gen_TreeNode n9 = new Gen_TreeNode(8,0);
        Gen_TreeNode n10 = new Gen_TreeNode(9,0);
        n1.children[0] = n2;
        n1.children[1] = n3;
        n1.children[2] = n4;

        n2.children[0] = n5;
        n3.children[0] = n6;

        n3.children[1] = n7;

        n4.children[0] = n8;
        n4.children[1] = n9;
        n4.children[2] = n10;

        tree_02 t = new tree_02(n1);
        System.out.println(t.BFS(10));
    }
}
