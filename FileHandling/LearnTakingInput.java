package FileHandling;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.IOException;

public class LearnTakingInput {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        
        //USING BUFFERREADER
//         Input is buffered, making it faster for large inputs.
// Suitable for competitive programming and performance-critical applications.
// Slightly verbose and harder to remember compared to Scanner.
        BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));

        try{
            String s = r.readLine();
        System.out.println(s);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //SCANNER
//         Easy to use and understand.
// Provides built-in methods like nextInt(), nextFloat(), etc.
// Slightly slower than BufferedReader due to parsing overhead.

Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        System.out.println("You entered string " + s1);

        int a = sc.nextInt();
        System.out.println("You entered integer " + a);

        float b = sc.nextFloat();
        System.out.println("You entered float " + b);

        sc.close();

        //USING CONSOLE
//         Reading password without echoing the entered characters.
// Reading methods are synchronized.
// Format string syntax can be used.
        Console console = System.console();
        if (console == null) {
            System.out.println("Console not available");
            return;
        }

        String s = console.readLine("Enter a string: ");
        System.out.println("You entered string " + s);

        //using command line arguments
        if (args.length > 0) {
            System.out.println("The command line arguments are:");
            for (String val : args)
                System.out.println(val);
        } else {
            System.out.println("No command line arguments found.");
        }


        //data input stream used for primitive datatypes only commonly used with data output stream
        DataInputStream dr = new DataInputStream(System.in);

        try{
            System.out.print("Enter an integer: ");
        int i = Integer.parseInt(dr.readLine());

        System.out.print("Enter a string: ");
        s = dr.readLine();

        System.out.println("You entered integer: " + i);
        System.out.println("You entered string: " + s);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
