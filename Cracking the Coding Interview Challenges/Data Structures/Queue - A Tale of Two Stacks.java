/////////////////////
// Generic version //
/////////////////////

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
    private ArrayDeque<T> stack1;
    private ArrayDeque<T> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<T>();
        stack2 = new ArrayDeque<T>();
    }
    
    public void enqueue(T e) {
        stack1.push(e);
    }

    public T dequeue() {
        /* Only see if the stack we are going to pop element from empty or not
        */ 
        if (stack2.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.pop();
    }

    public T peek() {
        /* same here */
        if (stack2.isEmpty()) {
            this.shiftOneToTwo();
        }
        return stack2.peek();
    }

    private void shiftOneToTwo() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

