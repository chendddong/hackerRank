public class Solution {
    public static void main(String[] args) {
        Class student = Student.class; // uses class literal, not a function.
        Method[] methods = student.getDeclaredMethods();

        
        ArrayList<String> methodNames = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        
        Collections.sort(methodNames);
        for (String name: methodNames) {
            System.out.println(name);
        }
    }
}

/*
    Reflection in Java Class.getDeclaredMethods();
 */