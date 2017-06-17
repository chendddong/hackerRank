///////////////////////////
// Non-recursive version //
///////////////////////////


import java.util.Scanner;
//  Time Complexity: O(n)
// Space Complexity: O(1)
public class Solution {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}

/*
    Use prev and curr as a temp variable
 */

///////////////////////
// Recursive version //
///////////////////////

import java.util.*;

public class Solution {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}