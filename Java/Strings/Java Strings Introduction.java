import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        /* Enter your code here. Print output to STDOUT. */
        String A=sc.next();
        String B=sc.next();

        /* Print the length */
        System.out.println(A.length()+B.length());

        /* Compare them alphabetically */
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");

        /* First Letter Capital Letter */
        System.out.println(A.substring(0, 1).toUpperCase()+A.substring(1, A.length())+" "+
                           B.substring(0, 1).toUpperCase()+B.substring(1, B.length()));

    }
}

/* 
    Another way to do it:
    
    System.out.println(capFirstLetter(A) + " " + capFirstLetter(B));    
 */