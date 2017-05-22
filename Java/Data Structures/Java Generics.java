import java.io.IOException;
import java.lang.reflect.Method;

/* Java Generic Methods*/
class Printer {
    public <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}

public class Solution {
    public static void main(String args[]) {
        Printer sc    = new Printer();
        Integer[] intArray   = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        sc.printArray(intArray);
        sc.printArray(stringArray);
        int count = 0;
        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();
            if (name.equals("printArray")) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}