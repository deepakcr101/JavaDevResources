package DecimalOperations;

public class PrecisionProblem {
    public static void main(String[] args) {
        // Using double for what looks like a simple calculation
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;

        System.out.println("Value of a = " + a);
        System.out.println("Value of b = " + b);
        System.out.println("Sum (a + b) = " + sum); // This will NOT be 0.3!

        // Checking for equality will fail
        if (sum == 0.3) {
            System.out.println("The sum is 0.3");
        } else {
            System.out.println("The sum is NOT 0.3");
        }
    }
}

// #Lesson:  Never use double or float for calculations that require exact precision, especially financial calculations (money). Comparing floating-point numbers for exact equality (==) is almost always a bad idea.