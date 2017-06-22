import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Hard code them all */
        double rjt = 12.0; 
        double p   = rjt / 100;
        int n      = 10;

        /* No more than 2 rejects (0, 1, 2) */
        double result1 = 0;
        for (int x = 0; x <= 2; x++) {
            result1 += binomial(n, x, p);
        }

        /*  
            At least 2 rejects (2,3,4, ... ,10). 
            We can calculate the complement and subtract that from 1. 
        */
        double result2_c = 0;
        for (int x = 0; x <= 1; x++) {
            result2_c += binomial(n, x, p);
        }

        /* Print the answer */
        System.out.format("%.3f\n", result1);
        System.out.format("%.3f\n", 1 - result2_c);
    }

    private static Double binomial(int n, int x, double p) {
        if (p < 0 || p > 1 || n < 0 || x < 0 || x > n) {
            return null;
        }
        return combinations(n, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
    }
    
    private static Long combinations(int n, int x) {
        if (n < 0 || x < 0 || x > n) {
            return null;
        }
        return factorial(n) / (factorial(x) * factorial(n - x));
    }
    
    /* non-recursive one */
    private static Long factorial(int n) {
        if (n < 0) {
            return null;
        }
        long result = 1;
        while (n > 0) {
            result *= n--;
        }
        return result;
    }    
}