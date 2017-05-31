import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public static final int NUM_LETTERS = 26;
    public static int numberNeeded(String first, String second) {
        /* Some edge cases -- anagrams */
        if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
            return 0;
        }
    /* always use int[26] and offset of ch - 'a' to store the value; */
        int[] array1 = createFilledArray(first);
        int[] array2 = createFilledArray(second);
        
        /* count how many numbers we need to delete */
        int results = 0;
        for (int i = 0; i < NUM_LETTERS; i++) {
            results += Math.abs(array1[i] - array2[i]);
        }
        /* result == 0 ? Anagram : not Anagram*/
        return results;
    }

    /* count of each Character in the array */
    private static int[] createFilledArray(String str) {
        int[] array = new int[NUM_LETTERS];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            array[val]++;
        }
        return array;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
