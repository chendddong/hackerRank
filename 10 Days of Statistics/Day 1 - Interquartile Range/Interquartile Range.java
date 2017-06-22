/////////////////////////////////
// Minor variation of Quartile //
/////////////////////////////////

import java.util.Scanner;
import java.util.Arrays;
import java.text.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        int [] array = getValues();
        Arrays.sort(array);
        
        double q1 = getMedian(array, 0, array.length / 2 - 1);
        double q3 = getMedian(array, (array.length + 1) / 2, array.length - 1);
    
        System.out.printf("%.1f\n" , (double)(q3 - q1));
    }
  
    /* Creates array from input */
    private static int [] getValues() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int [] array = new int[n];
        int [] frequency = new int[n];

        int len = 0;

        /* Scan the array */
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        /* Scan the frequency and get the length of the new array */
        for (int i = 0; i < n; i++) {
            frequency[i] = scan.nextInt();
            len += frequency[i];
        }
        scan.close();

        /* The new Array */
        int[] newArray = new int[len];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                newArray[index++] = array[i];
            }
        }
        return newArray;
    }
    
    /* Treats elements from "start" to "end" (inclusive) as an array and calculates its median */
    private static double getMedian(int [] array, int start, int end) {
        if ((end - start) % 2 == 0) { // odd number of elements
            return (array[(end + start) / 2]);
        } else { // even number of elements
            int value1 = array[(end + start) / 2];
            int value2 = array[(end + start) / 2 + 1];
            return Math.round((value1 + value2) / 2); 
        }
    }
}