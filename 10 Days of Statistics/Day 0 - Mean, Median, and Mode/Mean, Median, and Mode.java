import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        /* Scan input and put them in an array */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        /* Get three output respectively */
        double mean = getMean(arr);
        System.out.printf("%.1f\n", mean);

        double median = getMedian(arr);
        System.out.printf("%.1f\n", median);

        int mode = getMode(arr);
        System.out.printf("%d", mode);        
    }

    private static double getMean(int[] arr) {
        int sum = 0;
        for (Integer num : arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        return avg;
    }

    private static double getMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        /* Odd number */
        if (n % 2 != 0) {
            return (double) arr[n / 2];
        } 
        /* Even number */
        return (double) (arr[n / 2] + arr[(n / 2) - 1]) / 2;
    }

    private static int getMode(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int num : arr) {
            hash.merge(num, 1, Integer::sum);
        }
        int mode = Integer.MIN_VALUE;
        int maxOccur = 0;
        for (Integer num : arr) {
            if (hash.get(num) > maxOccur) {
                mode = num;
                maxOccur = hash.get(num);
            }
        }
        return mode;
    }
}