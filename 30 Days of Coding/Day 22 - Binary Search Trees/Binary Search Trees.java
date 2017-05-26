import java.util.*;
import java.io.*;

class Node {
    Node left, right;
    int data;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    /* We define a 1-Node tree to have height of 0 */
    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            /* Go left */
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            /* Go right */
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            /* Don't forget to return */
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root,data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}

/*
    1. Get the height of a BST
    2. Insert into a BST
 */