import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.HashMap;

// Why not use just a HashMap instead of both a HashMap and an ArrayDeque? 
// Well, an ArrayDeque helps keep the ordering of elements. Although the 
// elements are also in our HashMap, they is no ordering to the elements 
// in the HashMap since it's just a set.
    

public class test {
    public static void main(String [] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> deque     = new ArrayDeque<>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            /* Remove old value (if necessary) */
            if (i >= m) {
                int old = deque.removeFirst();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.merge(old, -1, Integer::sum);
                }
            }
            
            /* Add new value */
            int num = scan.nextInt();
            deque.addLast(num);
            map.merge(num, 1, Integer::sum);
            
            max = Math.max(max, map.size());
        }
        
        scan.close();
        System.out.println(max);
    }
}

/*
    Thoughts:
    
    1. Think about how the data structure is going to work, draw them and
    understand them.
    2. Some methods:
        Map.merge(element, 1, Integer::sum)---Add

        ---Remove
        if (map.get(old) == 1) {
            map.remove(old);
        } else {
            map.merge(old, -1, Integer::sum);
        }     

        Deque.addLast();
        Deque.removeFirst();   
    3. Use Deque and think about it in the future!!!

 */