package DecimalOperations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalOperations {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");

        // Addition
        BigDecimal sum = a.add(b); // a and b are unchanged, sum is a new object
        System.out.println("Sum: " + sum);

        // Subtraction
        BigDecimal difference = b.subtract(a);
        System.out.println("Difference: " + difference);

        // Multiplication
        BigDecimal product = a.multiply(b);
        System.out.println("Product: " + product);

        // Division - REQUIRES EXTRA CARE
        BigDecimal ten = new BigDecimal("10");
        BigDecimal three = new BigDecimal("3");

        try {
            // This will throw an ArithmeticException because 10/3 is a non-terminating decimal
            ten.divide(three);
        } catch (ArithmeticException e) {
            System.out.println("Error dividing 10 by 3: " + e.getMessage());
        }

        // CORRECT Division: Specify scale (number of decimal places) and a rounding mode
        BigDecimal divisionResult = ten.divide(three, 5, RoundingMode.HALF_UP);
        System.out.println("10 / 3 (rounded to 5 decimal places): " + divisionResult);
        
        // Comparing BigDecimal values
        // Do NOT use ==. Use the compareTo() method.
        // a.compareTo(b) returns:
        // -1 if a < b
        //  0 if a == b
        //  1 if a > b
        BigDecimal c = new BigDecimal("0.3");
        if (sum.compareTo(c) == 0) {
            System.out.println("The sum is exactly 0.3");
        }
    }
}