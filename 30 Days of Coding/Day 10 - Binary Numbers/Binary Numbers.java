import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(consecutiveOnes(n));
    }
    
    public static int consecutiveOnes(int n) {
        int count = 0;
        int max   = 0;
        while (n > 0) {
            /* start from right */
            if (n % 2 == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
            n = n >> 1;
        }
        return max;
    }
}

/*
    Very important. Max Consecutive things!!!! Bloomberg interview!!!
 */

/**
 *  ******Another variation:********
 *  
 *  Given a string, count the max consecutive character in the string.
 *
 *  return both number and the character.
 *
 *  Example:
 *  "aabbbaa"
 *  return "3->b";
 *
 *  bbbbaaaa
 *  return "4->b" or "4->a"
 */

class ResultType {
    /* There are the things we want */
    char token;
    int max;
    public ResultType(){}
    public ResultType(char token, int max) {
        this.token = token;
        this.max = max;
    }
}

public class Solution {

        public static ResultType getMaxConsecutiveString(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }

            int i = 0;
            int max = 0;
            int count = 1;
            ResultType result = new ResultType();

            /* Start from left side */
            while (i < s.length() - 1) {
                char same = s.charAt(i);
                if(s.charAt(i + 1) == same) {
                    count++;
                    max = Math.max(max, count);
                    /* if this max is larger than the exsisting max, update it*/
                    if (max > result.max) {
                        result = new ResultType(s.charAt(i), max);
                    }
                } else {
                    /* clear the count */
                    count = 1;
                }
                i++;
            }
            return result;
        }

        public static void main(String[] args) {
            String str = "bbbaaaa";
            ResultType result = getMaxConsecutiveString(str);
            /* Should be 4->a */
            System.out.print(result.max + "->" + result.token );
        }

}

/*
    Thoughts:
    1. How to use ResultType to return more than one result that we need.
    2. Think and debug, the process
 */