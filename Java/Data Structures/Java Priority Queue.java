import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      // size -- comparator  
      PriorityQueue<Student> pq = new PriorityQueue<>(totalEvents, new StudentComparator());  
      while(totalEvents > 0){
         String event = in.next();
         switch (event) {
             case "ENTER":
                String fname = in.next();
                double cgpa  = in.nextDouble();
                int    token = in.nextInt();
                pq.add(new Student(token, fname, cgpa));
                break;
             case "SERVED":
                pq.poll();
                break;
             default:
                break;
         }
           
         totalEvents--;
      }
      in.close();
        
      /* print names; */
        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                Student s = pq.remove();
                System.out.println(s.getFname());
            }
        }
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student  s2) {
        if (Double.compare(s1.getCgpa(), s2.getCgpa()) != 0) {
            return s1.getCgpa() < s2.getCgpa() ? 1 : -1; // descending order
        } else if (! s1.getFname().equals(s2.getFname())) {
            return s1.getFname().compareTo(s2.getFname());
        } else {
            return s1.getToken() - s2.getToken();
        }
    }
}
