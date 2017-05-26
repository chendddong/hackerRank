import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(factorial(n));
    }
    
    private static Long factorial (int n) {
        if (n < 0) {
            return null;
        }
        long result = 1;
        /* Start from the biggest number */
        while (n > 0) {
            result *= n--;
        }
        return result;
    }
}

/*
    Also can use recursive method.
 */