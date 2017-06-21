import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Scan input and put them two arrays */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrNum = new int[n];
        int[] arrWeight = new int[n];
        for (int i = 0; i < n; i++) {
            arrNum[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrWeight[i] = sc.nextInt();
        } 
        /* Always close the scanner immediately after the scan */  
        scan.close();

        double weightedMean = getWeightedMean(arrNum, arrWeight);
        System.out.printf("%.1f\n", weightedMean);
    }

    private static double getWeightedMean(int[] arrNum, int[] arrWeight) {
        int sumAll = 0;
        int sumWeight = 0;
        int n = arrNum.length;

        for (int i = 0; i < n; i++) {
            sumWeight += arrWeight[i];
            sumAll += arrNum[i] * arrWeight[i];
        }

        double weightedMean = (double) sumAll / sumWeight;
        return weightedMean;
    }
}