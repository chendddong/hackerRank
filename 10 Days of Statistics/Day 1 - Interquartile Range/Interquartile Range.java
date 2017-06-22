import java.io.*;
import java.util.*;

/*
    The ratio of boys to girls for babies born in Russia is . If there is 1 child born per birth, what proportion of
    Russian families with exactly 6 children will have at least 3 boys
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
            pSum += Math.pow(pBoys, i) * Math.pow(pGirls, n - i) * factorial(n) / (factorial(i) * factorial(n - i));
        }
        System.out.printf("%.3f\n", pSum);
    }

    private static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}