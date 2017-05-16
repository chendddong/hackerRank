import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt(); // 2
        for(int i=0;i<t;i++){
            int a = in.nextInt(); // 0
            int b = in.nextInt(); // 2
            int n = in.nextInt(); // 10
            
            
            for (int j = 0; j < n; j++) {
                int s_n = a + (int)(Math.pow(2, j) * b);
                System.out.print(s_n + " ");
                
                a = s_n;
                
            }

            System.out.println();
            
        }
        in.close();
    }
    

    
    
}
