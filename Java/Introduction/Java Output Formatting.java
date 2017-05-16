import java.util.Scanner;

public class Solution {

        
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //  how to format that 
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");

        }
    
}

/*
How to format the outcome--

The width specifies the number of characters used in total to display the
value and precision indicates the number of characters used after the decimal  
point.

For example, %10.3f will display the float using ten characters with three  
digits after the decimal point. Notice that the ten characters includes the  
decimal point, and a - sign if there is one. If the value needs more space than 
the width specifies then the additional space is used - width specifies the
smallest   space that will be used to display the value. (This is quiet
reassuring,   you won't be the first programmer whose program takes hours to run
but   the output results can't be viewed because the wrong format width has been
specified!)

The specifier %-1Od will display an int left justified in a ten character space.
The specifier %+5d will display an int using the next five character locations  
and will add a + or - sign to the value.


 */
