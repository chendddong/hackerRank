import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            String str = scan.next();
            printEvensOdds(str);
        }
        scan.close();
    }

    /* For efficient appending, use a StringBuffer instead of a String */
    public static void printEvensOdds(String str) {
        StringBuffer evens = new StringBuffer();
        StringBuffer odds  = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i % 2 == 0) {
                /* Since it starts with 0, but they are odd characters actually*/
                evens.append(ch);
            } else {
                odds.append(ch);
            }
        }
        System.out.println(evens + " " + odds);
    }
}

/*
    Thoughts:

    Always thinking about using the StringBuilder when it comes to string
    concatenation.
 */