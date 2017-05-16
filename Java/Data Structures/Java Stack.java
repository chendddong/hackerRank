import java.util.*;
class Solution{
   
   public static void main(String []argh)
   {
      // create a hash map to match opeing brackts with closing brackest
      HashMap<Character, Character> map = new HashMap<>();
      map.put('[', ']');
      map.put('{', '}');
      map.put('(', ')');       
      Scanner sc = new Scanner(System.in);
      
      while (sc.hasNext()) {
         String input = sc.next();
          System.out.println(isBalanced(input, map) ? "true" : "false" );
      }
      sc.close();
      
   }
    
    private static boolean isBalanced(String input, HashMap<Character, Character> map) {
        if ((input.length() % 2) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || ch != map.get(stack.pop())) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
