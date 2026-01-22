//package ExceptionHandling;

import java.io.FileReader;
import java.io.IOException;

public class LearnExceptionHandling {
    public static void main(String[] args) {
        int n = 10;
        int m = 0;

        try {
            int ans = n / m;
            System.out.println("Answer: " + ans);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by 0!");
        }

        int[] numbers = { 1, 2, 3 };
        try {
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Exception caught: " + e);
        } finally {
            System.out.println("This block always executes.");
        }
        System.out.println("Program continues...");

        // USING THROW
        checkAge(19);

        //THROWS USE
        try {
            readFile("test.txt");
        } catch (IOException e){
            
            System.out.println("File not found: " + e.getMessage());
        }

        //NESTED TRY CATCH
        try {
            System.out.println("Outer try block");
            try {
                int a = 10 / 0; // This causes ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e);
            }
            String str = null;
            System.out.println(str.length()); // This causes NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Outer catch: " + e);
        }

    }

    // throwing an exception
    static void checkAge(int age) {

        if (age < 18) {
            throw new ArithmeticException("Age must be 18 or above");
        }
    }

    //THROWS
    static void readFile(String fileName) throws IOException {
        
        FileReader file = new FileReader(fileName);
    }

}

// throw: Used to explicitly throw a single exception.
// We use throw when something goes wrong (or “shouldn’t happen”) and we want to
// stop normal flow and hand control to exception handling.


// throws: Declares exceptions that a method might throw, informing the caller to handle them

// #  If a method calls another method that throws a checked exception, and it doesn’t catch it, it must declare that exception in its throws clause

//The finally keyword in Java is used to create a block of code that always executes after the try block, regardless of whether an exception occurs or not.