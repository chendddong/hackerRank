import java.io.*;
import java.util.*;

class Node {
    Node left, right;
    int data;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>(); // use deque as a queue
        // deque.add(root);
        deque.offer(root);
        while (!deque.isEmpty()) {
            // Node n = deque.removeFirst();
            Node n = deque.poll();
            System.out.print(n.data + " ");
            if (n.left != null) {
                // deque.addLast(n.left);
                deque.offer(n.left);
            }
            if (n.right != null) {
                // deque.addLast(n.right);
                deque.offer(n.right);
            }
        }
    }


    public static Node insert(Node root,int data){
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            }
            else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }   
}

/*
    Use ArrayDeque to rule them all (stack & queue)
    If there is a request to return the same-level in on array, we should use a
    for loop to get all the stuff in the ArrayDeque
 */