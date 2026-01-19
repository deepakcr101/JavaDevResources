import java.util.*;

public class DecisionMaking {
    // control the flow of execution.
    public static void main(String args[]) {

        // if statement
        // If curly braces {} are omitted, only the next line after if is considered
        // part of the block
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Age: ");
        int age = sc.nextInt();

        if (age >= 18) {
            // System.out.println("You Can Vote");
            if (age < 20) {
                System.out.println("Welcome to Democarcy First Time Voters! ");
            } else if (age >= 20 && age < 60) {
                System.out.println("Go and Vote");
            } else {
                System.out.println("We Really Appreciate your effort You can avail senior citizen advantages.");
            }
        } else {
            System.out.println("Too Young to vote.");
        }

        // Switch in Java
        // It is a multiway branch statement. It provides an easy way to dispatch
        // execution to different parts of code based on the value of the expression.
        System.out.print("Enter the DayNumber: ");
        int day = sc.nextInt();
        String dayString;

        // Switch statement with int data type
        switch (day) {

            // Case
            case 1:
                dayString = "Monday";
                break;

            // Case
            case 2:
                dayString = "Tuesday";
                break;

            // Case
            case 3:
                dayString = "Wednesday";
                break;

            // Case
            case 4:
                dayString = "Thursday";
                break;

            // Case
            case 5:
                dayString = "Friday";
                break;

            // Case
            case 6:
                dayString = "Saturday";
                break;

            // Case
            case 7:
                dayString = "Sunday";
                break;

            // Default case
            default:
                dayString = "Invalid day";
        }
        System.out.println(dayString);

        /*
         * The expression can be of type byte, short, int char, or an enumeration.
         * Beginning with JDK7, the expression can also be of type String.
         * Duplicate case values are not allowed.
         * The default statement is optional.
         * The break statement is used inside the switch to terminate a statement
         * sequence.
         * The break statements are necessary without the break keyword, statements in
         * switch blocks fall through.
         */

        // Java switch expression must be of byte, short, int, long(with its Wrapper
        // type), enums and string. Beginning with JDK7, it also works with enumerated
        // types (Enums in java), the String class, and Wrapper classes.

        sc.close();
    }
}
