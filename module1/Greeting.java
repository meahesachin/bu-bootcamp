import java.util.Scanner;

public class Greeting {
        public static void main(String[] args) { 

            int a = 7; 
            int b = 2; 
            double result = a / b;
            double correct = (double) a / b; 

            Scanner scanner = new Scanner(System.in); 
            System.out.print("What is your name? "); 
            String name = scanner.nextLine(); 
            System.out.print("What is your role? "); 
            String role = scanner.nextLine(); 
            System.out.println("Hello, " + name + "! As a " + role + ", you are exactly in the right place."); 
            scanner.close(); 
         } 
}