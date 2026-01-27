package FileHandling;
import java.util.*;
import java.io.*;

public class LearnFileH {
    public static void main(String args[]){
System.out.println("Enter a character:");
int data=0;
        // Reads a single byte from System.in
        try{
            data = System.in.read();  
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // Print the character and its ASCII value
        System.out.println("You entered: " + (char) data);
        System.out.println("ASCII Value: " + data);

        int a=34;
        int b=56;
        System.out.print("Deepak Here 4 Fun!");
        System.out.println("Sum is "+ (a+b));
        System.out.println(a+" "+b);

        int x = 100;
      
        // Printing a simple integer
        System.out.printf("Printing simple integer: x = %d%n", x);

        // Printing a floating-point number with precision
        System.out.printf("Formatted with precision: PI = %.2f%n", Math.PI);

        float n = 5.2f;

        // Formatting a float to 4 decimal places
        System.out.printf("Formatted to specific width: n = %.4f%n", n);

        n = 2324435.3f;

        // Right-aligning and formatting a float to 20-character width
        System.out.printf("Formatted to right margin: n = %20.4f%n", n);

        // Using print()
        System.err.print("This is an error message using print().\n");

        // Using println()
        System.err.println("This is another error message using println().");

        //Using printf()
        System.err.printf("Error code: %d, Message: %s%n", 404, "Not Found");


        // streams
        //BYTE STREAM
        FileInputStream sourceStream = null;
        FileOutputStream targetStream = null;

        try {
            sourceStream
                = new FileInputStream("sourcefile.txt");
            targetStream
                = new FileOutputStream("targetfile.txt");

            // Reading source file and writing content to target file byte by byte
            int temp;
            while ((
                       temp = sourceStream.read())
                   != -1)
                targetStream.write((byte)temp);
        }
        catch(Exception e){
e.printStackTrace();
        }
        finally {
            if (sourceStream != null)
                try{
            sourceStream.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                
            if (targetStream != null)
                try{
            targetStream.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
        }


        //CHARACTER STREAMS
        FileReader sourceCharStream = null;
        
      	try {
            sourceCharStream = new FileReader("test.txt");

            // Reading sourcefile character by character.
            int temp;
          
            while (( temp = sourceCharStream.read())!= -1 )
                System.out.println((char)temp);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
          
            // Closing stream as no longer in use
            if (sourceCharStream != null)
                try{
            sourceCharStream.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
}
