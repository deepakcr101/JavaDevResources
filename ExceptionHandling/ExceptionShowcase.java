import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main class to demonstrate various exception types
public class ExceptionShowcase {

    public static void main(String[] args) {
        // --- DEMONSTRATING UNCHECKED (RUNTIME) EXCEPTIONS ---
        // These are typically programming errors.

        demonstrateArithmeticException();
        demonstrateNullPointerException();
        demonstrateArrayIndexOutOfBoundsException();
        demonstrateNumberFormatException();
        demonstrateClassCastException();

        // --- DEMONSTRATING CHECKED EXCEPTIONS ---
        // The compiler forces us to handle these.

        demonstrateCheckedException();

        // --- DEMONSTRATING USER-DEFINED EXCEPTIONS ---
        // For handling application-specific business logic errors.

        demonstrateUserDefinedException();
    }

    // 1. ArithmeticException (Unchecked)
    public static void demonstrateArithmeticException() {
        System.out.println("\n--- Demonstrating ArithmeticException ---");
        try {
            System.out.println("Attempting to divide by zero...");
            int result = 10 / 0; // This line will throw the exception
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) {
            System.err.println("Caught Exception: You cannot divide an integer by zero!");
            // e.printStackTrace(); // Uncomment to see the full stack trace
        }
    }

    // 2. NullPointerException (Unchecked)
    public static void demonstrateNullPointerException() {
        System.out.println("\n--- Demonstrating NullPointerException ---");
        try {
            String myString = null;
            System.out.println("Attempting to get length of a null string...");
            myString.length(); // This will throw the exception
        } catch (NullPointerException e) {
            System.err.println("Caught Exception: The object reference is null!");
        }
    }

    // 3. ArrayIndexOutOfBoundsException (Unchecked)
    public static void demonstrateArrayIndexOutOfBoundsException() {
        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException ---");
        try {
            int[] myArray = new int[3]; // Valid indices are 0, 1, 2
            System.out.println("Attempting to access index 5 of a 3-element array...");
            myArray[5] = 10; // This will throw the exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught Exception: Array index is out of bounds!");
        }
    }

    // 4. NumberFormatException (Unchecked)
    public static void demonstrateNumberFormatException() {
        System.out.println("\n--- Demonstrating NumberFormatException ---");
        try {
            String notANumber = "Ciena";
            System.out.println("Attempting to parse '" + notANumber + "' into an integer...");
            int num = Integer.parseInt(notANumber); // This will throw the exception
        } catch (NumberFormatException e) {
            System.err.println("Caught Exception: The string cannot be parsed into an integer.");
        }
    }

    // 5. ClassCastException (Unchecked)
    public static void demonstrateClassCastException() {
        System.out.println("\n--- Demonstrating ClassCastException ---");
        try {
            Object myObject = "I am a String object";
            System.out.println("Attempting to cast a String object to an Integer...");
            Integer myInteger = (Integer) myObject; // This will throw the exception
        } catch (ClassCastException e) {
            System.err.println("Caught Exception: Cannot cast object of one class to an incompatible class.");
        }
    }

    // 6. Checked Exception Example (FileNotFoundException)
    public static void demonstrateCheckedException() {
        System.out.println("\n--- Demonstrating a Checked Exception ---");
        File nonExistentFile = new File("this_file_does_not_exist.txt");
        // The 'finally' block is perfect for cleanup code like closing a scanner.
        Scanner fileScanner = null;
        try {
            System.out.println("Attempting to read a file that doesn't exist...");
            // The Scanner constructor can throw FileNotFoundException, which is checked.
            // Therefore, we MUST wrap this in a try-catch.
            fileScanner = new Scanner(nonExistentFile);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Caught Exception: The specified file was not found.");
        } finally {
            // This block ALWAYS runs, whether the file was found or not.
            System.out.println("The 'finally' block is executing for cleanup.");
            if (fileScanner != null) {
                fileScanner.close(); // Close the resource to prevent leaks.
                System.out.println("Scanner closed.");
            } else {
                System.out.println("Scanner was never opened.");
            }
        }
    }

    // 7. User-Defined Exception Example
    public static void demonstrateUserDefinedException() {
        System.out.println("\n--- Demonstrating a User-Defined Exception ---");
        try {
            // Attempt a withdrawal that will fail
            withdrawFromAtm(100.00, 200.00);
        } catch (InsufficientFundsException e) {
            System.err.println("Transaction failed. Reason: " + e.getMessage());
        }
    }

    // A method that can throw our custom exception. Note the 'throws' keyword.
    public static void withdrawFromAtm(double balance, double amountToWithdraw) throws InsufficientFundsException {
        System.out.println("Attempting to withdraw " + amountToWithdraw + " from a balance of " + balance);
        if (amountToWithdraw > balance) {
            // We have an exceptional business case, so we THROW our custom exception.
            throw new InsufficientFundsException("Withdrawal amount is greater than the current balance.");
        }
        // If no exception, proceed with logic
        System.out.println("Withdrawal successful!");
    }
}

// --- PART 3: DEFINING A USER-DEFINED EXCEPTION ---
// This is our custom exception class.
// By extending 'Exception', we make it a CHECKED exception.
// If we extended 'RuntimeException', it would be an unchecked exception.
class InsufficientFundsException extends Exception {

    // Constructor that accepts a message
    public InsufficientFundsException(String message) {
        // Pass the message up to the parent 'Exception' class constructor
        super(message);
    }
}