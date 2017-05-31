////////////////////////////////
// Solution 1 Using a HashMap //
////////////////////////////////


import java.io.*;
import java.util.*;

public class Solution {
    //  Time Complexity: O(n) using a HashMap
    // Space Complexity: O(n)
    static boolean isAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        
        /* Fill HashMap with 1st String */
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            map.merge(ch, 1, Integer::sum);
        }
        
        /* Compare 2nd String to 1st String's HashMap */
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


/*
    How to use merge in the HashMap
 */

////////////////////////////////////////
// Solution 2 Using Character Offset //
////////////////////////////////////////


import java.io.*;
import java.util.*;

public class Solution {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        // Hello     olleh
        if (a.length() != b.length()) {
            return false;
        }
        /* store numbers of Character */
        int[] count = new int[26];
        a = a.toLowerCase();
        b = b.toLowerCase();

        /* traverse String a, store offset value and how many*/
        for (int i = 0; i < a.length(); i++) {
            int val = a.charAt(i) - 'a';
            count[val]++;
        }
        
        /* same for String b */
        for (int i = 0; i < b.length(); i++) {
            int val = b.charAt(i) - 'a';
            count[val]--;
        }
        
        /* See if there is any character left in the count array */
        for (Integer num : count) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }

  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

