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