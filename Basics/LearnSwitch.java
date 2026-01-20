import java.util.Scanner;;

public class LearnSwitch {
    public enum Day {
        Sun, Mon, Tue, Wed, Thu, Fri, Sat
    }

    // switch statement in Java is a multi-way branch statement
    // In simple words, the Java switch statement executes one statement from
    // multiple conditions.
    // The expression can be of type byte, short, char, int, long, enums, String, or
    // wrapper classes (Integer, Short, Byte, Long).
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Simple Switch
        // Replace with desired size (1, 2, 3, 4, or 5)
        int size = 2;

        switch (size) {
            case 1:
                System.out.println("Extra Small");
                break;
            case 2:
                System.out.println("Small");
                break;
            case 3:
                System.out.println("Medium");
                break;
            case 4:
                System.out.println("Large");
                break;
            case 5:
                System.out.println("Extra Large");
                break;
            default:
                System.out.println("Invalid size number");
        }

        // Nested Switch
        System.out.println("Enter Your Branch->CSE,CCE or ECE : ");
        String Branch = sc.next();
        System.out.println("Enter Your Academic Year: ");
        int year = sc.nextInt();

        // Switch case
        switch (year) {

            // Case
            case 1:
                System.out.println("elective courses : Advance english, Algebra");

                // Break statement to hault execution here
                // itself if case is matched
                break;

            // Case
            case 2:

                // Switch inside a switch
                // Nested Switch
                switch (Branch) {

                    // Nested case
                    case "CSE":
                        System.out.println("Computer Science,Software Engineering");
                        break;

                    case "CCE":
                        System.out.println("elective courses : Machine Learning, Big Data");
                        break;

                    // Case
                    case "ECE":
                        System.out.println("elective courses : Antenna Engineering");
                        break;

                    // default case
                    // It will execute if above cases does not
                    // execute
                    default:

                        // Print statement
                        System.out.println("Elective courses : Optimization");
                }
        }

        // enums in java
        // Enums in Java are a powerful feature used to represent a fixed set of
        // constants.

        // They can be used in switch statements for better type safety and readability.
        // Enum
        Day[] DayNow = Day.values();

        // Iterating using for each loop
        for (Day Now : DayNow) {

            // Switch case
            switch (Now) {

                // Case 1
                case Sun:
                    System.out.println("Sunday");

                    // break statement that hault further
                    // execution once case is satisfied
                    break;

                // Case 2
                case Mon:
                    System.out.println("Monday");
                    break;

                // Case 3
                case Tue:
                    System.out.println("Tuesday");
                    break;

                // Case 4
                case Wed:
                    System.out.println("Wednesday");
                    break;

                // Case 5
                case Thu:
                    System.out.println("Thursday");
                    break;

                // Case 6
                case Fri:
                    System.out.println("Friday");
                    break;

                // Case 7
                case Sat:
                    System.out.println("Saturday");
            }
        }

        System.out.println("Enter Your Age: ");
        Integer age = sc.nextInt();

        switch (age) { // Extract primitive value for switch
            case 25:
                System.out.println("You are 25.");
                break;
            case 30:
                System.out.println("You are 30.");
                break;
            default:
                System.out.println("Age not matched.");
        }

        sc.close();
    }
}

/*
 * Some Important Rules for Java Switch Statements
 * Case values must be constants or literals and of the same type as the switch
 * expression.
 * Duplicate case values are not allowed.
 * The break statement is used to exit from the switch block. It is optional but
 * recommended to prevent fall-through.
 * The default case is optional and executes if no case matches the switch
 * expression. It can appear anywhere within the switch block.
 */

// The switch argument can be a variable expression but the case labels must be
// constant expressions.