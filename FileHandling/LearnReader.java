package FileHandling;

import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Arrays;

public class LearnReader {
    public static void main(String[] args) {
        try {
          
            // Create a FileReader object which is a subclass of Reader
            Reader r = new FileReader("test.txt");

            // Read one character at a time from the file
            int data = r.read();
            while (data != -1) {
              
                // Convert the int to char and print
                System.out.print((char)data);
                data = r.read();
            }
           System.out.println();
            // Close the reader
            r.close();
        }
        catch (Exception ex) {
          System.out.println("An error occurred: " + ex.getMessage());
        }

        try{
            // Open a file reader
        Reader mr = new FileReader("sourcefile.txt");
        PrintStream out = System.out;

        // Create a character array and CharBuffer
        char[] buffer = new char[10];
        CharBuffer charBuffer = CharBuffer.wrap(buffer);

        // Check if the reader supports marking
        if (mr.markSupported()) {
            mr.mark(100); // Mark the current position
            out.println("mark method is supported");
        }

        // Skip 5 characters in the stream
        mr.skip(5);

        // Check if the stream is ready to read
        if (mr.ready()) {
            // Read 10 characters into the buffer
            mr.read(buffer, 0, 10);
            out.println("Buffer after reading 10 chars: "
                        + Arrays.toString(buffer));

            // Read characters into the CharBuffer
            mr.read(charBuffer);
            out.println(
                "CharBuffer contents: "
                + Arrays.toString(charBuffer.array()));

            // Read a single character
            out.println("Next character: "
                        + (char)mr.read());
        }

        // Close the reader
        mr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            
            // FileReader Class used
            FileReader fileReader = new FileReader("example.txt");

            System.out.println("Reading char by char : \n");
            int i;

            // Using read method
            while ((i = fileReader.read()) != -1) {
                System.out.print((char)i);
            }

            System.out.println("Reading using array : \n");
            char[] charArray = new char[10];

            // Using read method for to get character array
            fileReader.read(charArray);
            System.out.print(charArray);

            // Close method called
            fileReader.close();
            System.out.println("FileReader closed!");
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
