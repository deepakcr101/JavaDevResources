package DecimalOperations;

import java.math.BigDecimal;

public class BigDecimalCreation {
    public static void main(String[] args) {
        // THE WRONG WAY: Using the double constructor
        // This passes the imprecise double value into the BigDecimal,
        // so you are just preserving the error.
        BigDecimal badDecimal = new BigDecimal(0.1);
        System.out.println("Bad way: new BigDecimal(0.1) -> " + badDecimal);

        // THE RIGHT WAY: Using the String constructor
        // The String provides an exact representation of the number.
        BigDecimal goodDecimal = new BigDecimal("0.1");
        System.out.println("Good way: new BigDecimal(\"0.1\") -> " + goodDecimal);

        // A GOOD ALTERNATIVE: Using the static valueOf method
        // This is often preferred as it can reuse common BigDecimal objects
        // and uses the canonical string representation of the double.
        BigDecimal valueOfDecimal = BigDecimal.valueOf(0.1);
        System.out.println("Alternative: BigDecimal.valueOf(0.1) -> " + valueOfDecimal);
    }
}