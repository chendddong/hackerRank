import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayDeque;

/* is the String brackets balanced */
public class Solution {
    public static void main(String[] args) {
        /* Create HashMap to match opening brackets with closing brackets */
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        /* Test each expression for validity */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            String expression = scan.next();
            System.out.println(isBalanced(expression, map) ? "YES" : "NO" );
        }
        scan.close();
    }
    
    private static boolean isBalanced(String expression, HashMap<Character, Character> map) {
        if ((expression.length() % 2) != 0) {
            return false; // odd length Strings are not balanced
        }        
        ArrayDeque<Character> deque = new ArrayDeque<>(); 

        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            if (map.containsKey(ch)) {
                deque.push(ch);
            } else if (ch == map.get(deque.peek())) {
                deque.pop();
            } else {
                return false;
            }       
        }



        return deque.isEmpty();
    }
}



/////////////////////////////////////////////////////////////////////////////
// ======================================================================= //
/////////////////////////////////////////////////////////////////////////////

/*
    Another problem Bracket Match

A string of brackets is considered correctly matched if every opening bracket
in the string can be paired up   with a later closing bracket, and vice
versa.   For instance, “(())()” is correctly matched, whereas “)(“ and “((”
aren’t. For   instance, “((” could become correctly matched by adding two
closing brackets at the end, so you’d return 2.

Given a string that consists of brackets, write a function bracketMatch that
takes a bracket string as an input and returns the minimum number of
brackets you’d need to add to the input in order to make it correctly matched.
*/


// Explain the correctness of your code, and analyze its time and space complexities.

// Examples:

// input:  text = “(()”
// output: 1

// input:  text = “(())”
// output: 0

// input:  text = “())(”
// output: 2
// Constraints:

// [time limit] 5000ms

// [input] string text

// 1 ≤ text.length ≤ 5000
// [output] integer

//////////////////////////////////////
// Solution 1 Using Data Structures //
//////////////////////////////////////


class Solution {
    public static int bracketMatch(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        int n = str.length();
        int count = n;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            /* open brackets just add them to the stack */
            if (map.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            /* If found match pairs just decrement two from the total */
            } else if (!stack.isEmpty() && str.charAt(i) == map.get(stack.pop())) {
                count -= 2;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        String str1 = "(){}{{{[][]"; // 3
        String str2 = "(((((((";// 7
        String str3 = "(){}[]"; // 0
        int ans1 = bracketMatch(str1);
        int ans2 = bracketMatch(str2);
        int ans3 = bracketMatch(str3);
        System.out.println(str1 + " -- " + (ans1));
        System.out.println(str2 + " -- " + ans2);
        System.out.println(str3 + " -- " + ans3);


    }

}

/////////////////////////////
// Solution 2 Using Counts //
/////////////////////////////

class Solution {
    public static int bracketMatch(text) {
        int diffCounter = 0;
        int ans = 0;
        int n = text.length();

        for (int i = 0; i < n; i++) {
            if ( text.charAt(i) == '(' )
                diffCounter += 1;
            else if ( text.charAt(i) == ')' )
                diffCounter -= 1;
            if ( diffCounter < 0 ) {
                diffCounter += 1;
                ans += 1;               
            }
            
        }
        return ans + diffCounter;       
    }


    public static void main(String args[]) {
        String str1 = "(){}{{{[][]"; // 3
        String str2 = "(((((((";// 7
        String str3 = "(){}[]"; // 0
        int ans1 = bracketMatch(str1);
        int ans2 = bracketMatch(str2);
        int ans3 = bracketMatch(str3);
        System.out.println(str1 + " -- " + (ans1));
        System.out.println(str2 + " -- " + ans2);
        System.out.println(str3 + " -- " + ans3);


    }

}

