import java.io.*;
import java.util.*;

interface AdvancedArithmetic {
   int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
    //          Runtime: O(n^(1/2))
    // Space Complexity: O(1)
    public int divisorSum(int n) {
        int sum = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) { // if "i" is a divisor
                sum += i + n/i; // add both divisors
            }
        }
        /* If sqrt is a divisor, we should only count it once */
        if (sqrt * sqrt == n) {
            sum -= sqrt;
        }
        return sum;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
        AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}

/*
    ===========================================================================
                                Interfaces

    An interface is a collection of abstract methods and constants that form a common set of base rules/specifications for those classes that implement it. Much like an abstract class, an interface cannot be instantiated and must be implemented by a class. 

    An interface is a contract: The guy writing the interface says, "hey, I accept things looking that way", and the guy using the interface says "OK, the class I write looks that way".

    An interface is an empty shell. There are only the signatures of the methods, which implies that the methods do not have a body. The interface can't do anything. It's just a pattern.
    ===========================================================================
                                Abstract classes

    Abstract classes, unlike interfaces, are classes. They are more expensive to use, because there is a look-up to do when you inherit from them.

    Abstract classes look a lot like interfaces, but they have something more: You can define a behavior for them. It's more about a guy saying, "these classes should look like that, and they have that in common, so fill in the blanks!".
    ===========================================================================
 */

//////////////////////////////////
// Check if the number is prime //
//////////////////////////////////

import java.util.Scanner;

public class Solution {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        while (p-- > 0) {
            int n = scan.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
        scan.close();
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}