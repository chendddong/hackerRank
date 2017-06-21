/////////////////////////////////////////
// Solution #0 Reuse the code in day 0 //
/////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Save the inputs in one big array */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrAll = new int[n];
        for (int i = 0; i < n; i++) {
            arrAll[i] = sc.nextInt();
        }
        sc.close();

        /* Sort the big array */
        Arrays.sort(arrAll);

        /* Divide the array into two parts */
        int[] arrLower = new int[n / 2];
        int[] arrUpper = new int[n / 2];

        /* Lower array */
        for (int i = 0; i < n / 2; i++) {
            arrLower[i] = arrAll[i];
        }  

        /* Upper array */
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                arrUpper[i] = arrAll[i + (n / 2)];
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                arrUpper[i] = arrAll[i + (n / 2) + 1];
            }
        }

        int Q1 = getMedian(arrLower);
        int Q2 = getMedian(arrAll);
        int Q3 = getMedian(arrUpper);

        System.out.printf("%d\n", Q1);        
        System.out.printf("%d\n", Q2);        
        System.out.printf("%d\n", Q3);           
    }

    private static int getMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        /* Odd number */
        if (n % 2 != 0) {
            return arr[n / 2];
        } 
        /* Even number */
        return (arr[n / 2] + arr[(n / 2) - 1]) / 2;
    }    
}

////////////////////////////////////////////////
// Solution #1 Rewrite the getMedian() method //
////////////////////////////////////////////////

import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] array = getValues();
        Arrays.sort(array);
        
        int q1 = getMedian(array, 0, array.length / 2 - 1);
        int q2 = getMedian(array, 0, array.length - 1);
        int q3 = getMedian(array, (array.length + 1) / 2, array.length - 1);
        
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }

    /* Creates array from input */
    private static int [] getValues() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        return array;
    }
    
    /* Treats elements from "start" to "end" (inclusive) as an array and calculates its median */
    private static int getMedian(int [] array, int start, int end) {
        if ((end - start) % 2 == 0) { // odd number of elements
            return (array[(end + start) / 2]);
        } else { // even number of elements
            int value1 = array[(end + start) / 2];
            int value2 = array[(end + start) / 2 + 1];
            return Math.round((value1 + value2) / 2); 
        }
    }
}