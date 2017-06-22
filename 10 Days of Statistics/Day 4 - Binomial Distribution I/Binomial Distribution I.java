//////////////////////
// Initial version  //
//////////////////////

import java.io.*;
import java.util.*;

/*
    The ratio of boys to girls for babies born in Russia is . If there is 1 child born per birth, what proportion of Russian families with exactly 6 children will have at least 3 boys
 */


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ratioBoy = sc.nextDouble();
        double ratioGirl = sc.nextDouble();
        sc.close();

        int n = 6;
        int x = 3;

        double pBoys = ratioBoy / (ratioBoy + ratioGirl);
        double pGirls = ratioGirl / (ratioBoy + ratioGirl);

        // b(x >= 3, 6, pBoys) :
        // P(x = 3) + P(x = 4) + P(x = 5) + P(x = 6)      

        double pSum = 0;
        for (int i = x; i <= n; i++) {
            double pSum += Math.pow(pBoys, i) * Math.pow(pGirls, n - i) *
            factorial
            (n) / (factorial(i) *
               factorial(n - i));            
        }
        System.out.printf("%f.3\n", pSum);
    }

    private static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}

////////////////////////////
// Much more tidy version //
////////////////////////////

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        double ratio = 1.09; // hardcoded value
        double p     = ratio / (1 + ratio);
        int    n     = 6;
        
        /* Calculate result */
        double result = 0;
        for (int x = 3; x <= n; x++) {
            result += binomial(n, x, p);
        }
        System.out.format("%.3f", result);
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