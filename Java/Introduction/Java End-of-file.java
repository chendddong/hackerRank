import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.print(count++);
            System.out.print(" " + line);
            System.out.println("");
        }
    }
}