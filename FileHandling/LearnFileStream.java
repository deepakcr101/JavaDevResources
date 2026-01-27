package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LearnFileStream {
    public static void main(String[] args) {
         // Use try-with-resources to automatically close the
        // stream
        try (FileInputStream fi
             = new FileInputStream("test.txt")) {

            // Display file channel information
            System.out.println("Channel: "
                               + fi.getChannel());

            // Display file descriptor
            System.out.println("File Descriptor: "
                               + fi.getFD());

            // Show available bytes in the stream
            System.out.println("Number of remaining bytes: "
                               + fi.available());

            // Skip first few bytes
            fi.skip(4);

            System.out.println("File Contents:");

            // Read and print file content
            int ch;
            while ((ch = fi.read()) != -1) {
                System.out.print((char)ch);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(
                "File not found: Ensure 'file1.txt' exists in the working directory.");
        }
        catch (IOException e) {
            System.out.println(
                "An error occurred while reading the file: "
                + e.getMessage());
        }

        //outputstream
        String data = "Hello, World! Writing into the file specified";

        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
                 
            // Convert the string into bytes
            byte[] dataBytes = data.getBytes();

            // Write the bytes to the file
            fos.write(dataBytes);

            System.out.println("Data successfully written to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


        String s = System.getProperty("user.dir");

        // Print the current directory
        System.out.println("Current working directory: " + s);

        // Use try-with-resources to ensure the stream is closed automatically
        try (FileOutputStream fout = new FileOutputStream("name3.txt", false)) { 

            // String to be written to the file
            String st = "TATA";

            // Convert the string to a byte array and write it directly
            fout.write(st.getBytes());

        } catch (IOException e) {
            
            // Handle exceptions if file operations fail
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
}
