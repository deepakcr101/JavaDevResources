package Methods;

//Variable Arguments (Varargs) allow methods that can take any number of inputs, which simply means we do not have to create more methods for different numbers of parameters

/*
Varargs lets a method to take many values or even no value at all. Java will treat these values like a list, so that we can use them inside the method easily.
*/

//Only one Varargs parameter is allowed per method.

public class VariableArgs {
    public static void main(String args[]) {
        // CommaND lINE aGUMENTS
        // Checking if length of args array is
        // greater than 0
        if (args.length > 0) {

            // Print statements
            System.out.println("The command line"
                    + " arguments are:");

            // Iterating the args array
            // using for each loop
            for (String val : args)

                System.out.println(val);
        } else

            System.out.println("No command line "
                    + "arguments found.");

        // Calling the 'Names' method with different number of arguments
        Names("Deepak", "Rahul");
        Names("Deeapk", "Harsh", "Priyam");

        // Calling fun2() with different parameter
        fun2("DeeapkHere", 100, 200);
        fun2("CSPortal", 1, 2, 3, 4, 5);
        fun2("forLearning");
    }

    public static void Names(String... n) {

        // Iterate through the array and print each name
        for (String i : n) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void fun2(String s, int... a) {
        System.out.println("String: " + s);
        System.out.println("Number of arguments is: "
                + a.length);
        // using for each loop to display contents of a
        for (int i : a)
            System.out.print(i + " ");

        System.out.println();
    }

}
