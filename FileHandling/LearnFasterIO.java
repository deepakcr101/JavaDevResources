package FileHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//for faster inputs
//Buffered Reader is fast but not recommended as it requires a lot of typing.
//The Scanner class is easy to use and requires less typing, but it's slower and not recommended for performance-critical tasks.

public class LearnFasterIO {
    // FastReader class for efficient input
    static class FastReader {
      
        // BufferedReader to read input
        BufferedReader b;
      
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() { 
            return Integer.parseInt(next()); 
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }

    public static void main(String[] args) {
      
        // Create a FastReader instance for input
        FastReader s = new FastReader();

        // Read the number of integers (n) and the divisor (k)
        int n = s.nextInt();
        int k = s.nextInt();

        // Initialize count for divisible numbers
        int c = 0; 

        // Loop through the integers
        while (n-- > 0) {
          
            // Read the next integer
            int x = s.nextInt(); 
          
            // Check if divisible by k
            if (x % k == 0) 
                c++; 
        }

        System.out.println(c);
    }
}
