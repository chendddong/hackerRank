////////////////////////////
// Solution 1 Comparisons //
////////////////////////////

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /* Save input */
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int k    = scan.nextInt();
        scan.close();        

        /* Create smallest and largest strings and initialize them */
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 0; i <= s.length() - k; ++i) {
            String curr = s.substring(i, i + k);
            if (smallest.compareTo(curr) > 0) {
                smallest = curr;
            }

            if (largest.compareTo(curr) < 0) {
                largest = curr;
            }
        }

        /* Print results */
        System.out.println(smallest);
        System.out.println(largest);
    }
}

//////////////////////////////////
// Solution 2 Using a SortedSet //
//////////////////////////////////

import java.io.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int k = scan.nextInt();
        scan.close();

        /* Put all the substrings in the sorted set */
        SortedSet<String> sets = new TreeSet<String>();
        for(int i = 0 ;i <= str.length() - k; i++){
            sets.add(str.substring(i, i + k));
        }

        /* Print them all */
        System.out.println(sets.first());
        System.out.println(sets.last());
        
    }
}
