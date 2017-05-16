/////////////////////////////////////////
// Solution 1 Trim & Split the string  //
/////////////////////////////////////////



import java.io.*;
import java.util.*;
public class Solution {
/*  
    1) trim the string 
    2) handle string.length() > 400000 => don't print anything
    3) handle string.length() == 0 => print "0"
*/  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        /* check corner cases */
        if (s.trim().length() == 0 || s.trim().length() > 400000)
        {
            System.out.println(0);
            return;
        }
        /* eliminate other non-token characters */
        String[] newStr = s.trim().split("[ !,?.\\_'@]+");

        /* Print output */
        System.out.println(newStr.length);
        for (String str : newStr) {
            System.out.println(str);
        }
        scan.close();
    }
}


////////////////////////////////////////////////
// Solution 2 Leave the Alphabetic characters //
////////////////////////////////////////////////


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /* Read input */
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        
        s = s.trim(); // so that .split() works properly
        
        /* Check special cases */
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        
        /* Split on all non-alphabetic characters */
        String [] words = s.split("[^a-zA-Z]+");
        
        /* Print output */
        System.out.println(words.length);
        for (String word : words) {
            System.out.println(word);
        }
    }
}