package FileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class LearnWriter {
    public static void main(String[] args) {
        try {
          
            // Create a FileWriter to write to a file named "example.txt"
            FileWriter w = new FileWriter("example.txt");

            // Write a simple message to the file
            w.write("Hello, World!");

            // Close the writer
            w.close();

            System.out.println("Message written");
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        try {
            Writer writer = new FileWriter("example1.txt");
            writer.write("Hello, Java Writer Class!");
            writer.close();
            System.out.println(
                "Data written successfully.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer writer = new BufferedWriter(
                 new FileWriter("buffered.txt"))) {
            writer.write(
                "BufferedWriter makes writing more efficient.");
            writer.write(
                "\nIt reduces disk I/O by using a buffer.");
            System.out.println(
                "Data written using BufferedWriter.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (Writer writer = new FileWriter("example.txt", true)) {
            writer.write("\nThis line was appended later.");
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = "output.txt";
      	// Appending Data in the File
       	try (FileWriter writer = new FileWriter(fileName, true)) { 
          	
          	// true for append mode
          	writer.write("\nAppending this line to the file.");
          	System.out.println("Data appended to the file successfully.");
		} 
      	catch (IOException e) {
    		System.out.println("An error occurred while appending"
                               + " to the file: " + e.getMessage());
		}
        
    }
}
