import java.util.*;

public class Loops {
    public static void main(String args[]) {
        // allow a set of instructions to run multiple times based on conditions
        Scanner sc = new Scanner(System.in);
        // FOR LOOP
        // used when we know the exact number of iterations
        // three parts initialization,condition,updation
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // For Each loop Internally handled
        // This loop is used to iterate over arrays or collections.
        String[] names = { "Deepak Kumar", "Priyam Maini", "Rahul Batra Sir" };

        for (String name : names) {
            System.out.println("Name: " + name);
        }

        // While loop
        // used when we need to check condition before executing the loop body
        // also called Entry control loop
        int i = 0;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        // DO WHILE LOOP Exit-controlled.
        // used when we want to execute the loop body atleast one time before checking
        // condition
        String[] menu = { "Tea", "Coffee", "Matcha" };
        boolean keepShowing = true;
        do {

            System.out.print("Enter Your Choice 1: For Tea \n 2: For Coffee \n 3: For Matcha \n and 0: To Exit : ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 0:
                    System.out.println("Exiting The Loop.");
                    keepShowing = false;
                    break;
                case 1:
                    System.out.println(menu[0] + "Preparing Tea Enjoy! ");
                    break;
                case 2:
                    System.out.println(menu[1] + "Preparing Coffee Enjoy!");
                    break;
                case 3:
                    System.out.println(menu[2] + "Enjoy Your Matcha!");
                    break;

                default:
                    System.out.println("Invalid Request");
                    keepShowing = false;
                    break;
            }
        } while (keepShowing);

        // JUMP STATEMENTS
        // jump statements are used to alter the normal flow of program execution when
        // certain conditions are met. They can be used to terminate a loop, skip an
        // iteration, or exit from a method or block of code

        // CONTINUE : to skip some iterations
        for (i = 0; i < 5; i++) {
            if (i == 2) {
                System.out.println();
                // using continue keyword
                // to skip the current iteration
                continue;
            }
            System.out.println(i);
        }

        // BREAK: to exit the loop
        // used to terminate the execution of the nearest looping statement or switch
        // statement. The break statement is widely used with the switch statement, for
        // loop, while loop, and do-while loop

        int n = 10;
        for (i = 0; i < n; i++) {
            if (i == 4)
                break;
            System.out.println(i);
        }

        // USE OF BREAK AS GOTO
        // java doesnt have goto clause but we can use break as it
        for (i = 0; i < 3; i++) {
            one: { // label one
                two: { // label two
                    three: { // label three
                        System.out.println("i=" + i);
                        if (i == 0)
                            break one; // break to label one
                        if (i == 1)
                            break two; // break to label two
                        if (i == 2)
                            break three; // break to label three
                    }
                    System.out.println("after label three");
                }
                System.out.println("after label two");
            }
            System.out.println("after label one");
        }

        // RETURN STATEMENT: used to transfer control from one method to the parent
        // method
        int result = calculateSum(5, 10);

        // Print the result
        System.out.println("Result: " + result);
        sc.close();
    }

    public static int calculateSum(int num1, int num2) {
        // Print a message indicating the method has started
        System.out.println("Calculating the sum of " + num1
                + " and " + num2);
        int sum = num1 + num2;
        System.out.println("The sum is: " + sum);

        // Return the calculated sum
        return sum;

        // Note: Any code after the 'return' statement will
        // not be executed. But "Final" is an exception in
        // the case of try-catch-final block.
        // System.out.println("end"); // error : unreachable
        // statement
    }
}
