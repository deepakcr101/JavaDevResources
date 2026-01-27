package Java8;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


class Transaction {
    private int id;
    private int value;
    private String type;

    public Transaction(int id, int value, String type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}


public class LearnStreams {
    public static void main(String[] args) {
        // 1. From a Collection
        List<String> list = Arrays.asList("Java", "Python", "C++");
        Stream<String> stream1 = list.stream();

        // 2. From an Array
        String[] arr = {"A", "B", "C"};
        Stream<String> stream2 = Arrays.stream(arr);

        // 3. Using Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        // 4. Infinite Stream (limit to avoid infinite loop)
        Stream<Integer> stream4 = Stream.iterate(1, n -> n + 1).limit(5);
        stream4.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(5, 10, 20, 10, 30, 40);

        numbers.stream()
               .filter(n -> n > 10)   // keep > 10
               .map(n -> n * 2)       // double them
               .distinct()            // remove duplicates
               .sorted()              // sort ascending
               .forEach(System.out::println);
        
        List<String> names = Arrays.asList("Amit", "Riya", "Rohan", "Amit");

        // Collect into Set (removes duplicates)
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        System.out.println(uniqueNames);

        // Count names starting with 'R'
        long count = names.stream().filter(n -> n.startsWith("R")).count();
        System.out.println("Names starting with R: " + count);

        // Reduce (concatenate names)
        String result = names.stream().reduce("", (a, b) -> a + b + " ");
        System.out.println(result);


        List<String> names1 = Arrays.asList("A", "B", "C", "D");

        names1.stream()
             .forEach(System.out::println); // Executes sequentially

       //parallel streams
       List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,6,7,8,9);

       numbers1.parallelStream().forEach(n -> System.out.println(n + " " + Thread.currentThread().getName()));

     //Infinite Streams
     Stream.iterate(1, n -> n + 1)
              .limit(5)
              .forEach(System.out::println);

    
    //Primitive streams
     IntStream.range(1, 5).forEach(System.out::println);
     LongStream.rangeClosed(10000000,10000009).forEach(System.out::print);
     
    //file operations
    // Replace with the actual file path
        String fileName = "Java8\\myFile.txt";

        // Step 1: Create a Stream of lines from the file
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {

            List<String> filteredStrings = filterAndConvertToUpper(lines, 5);
            System.out.println("Filtered strings with length 5 (converted to uppercase): "+ filteredStrings);
        }
        catch (IOException e) {e.printStackTrace();
        }


        //File Write Operations
        String[] words
            = { "Deepak", "Here", "For", "Learning", "Streams" };

        // Replace with the actual file path


        // Step 1: Create a PrintWriter to write to the file
        try (PrintWriter pw
             = new PrintWriter(Files.newBufferedWriter(
                 Paths.get(fileName)))) {

            // Step 2: Use Stream to write each word to the file
            Stream.of(words).forEach(pw::println);

            // Step 3: Print success message to the console
            System.out.println(
                "Words written to the file successfully.");
        }
        catch (IOException e) {
            // Step 4: Handle any IO exception that occurs during the file writing process
            e.printStackTrace();
        }


        //Real world example
        List<Transaction> transactions = Arrays.asList(
            new Transaction(1, 100, "GROCERY"),
            new Transaction(3, 80, "GROCERY"),
            new Transaction(6, 120, "GROCERY"),
            new Transaction(7, 40, "ELECTRONICS"),
            new Transaction(10, 50, "GROCERY")
        );

        // Stream pipeline based on your diagram
        List<Integer> transactionIds = transactions.stream()
                .filter(t -> t.getType().equals("GROCERY"))       // keep only groceries
                .sorted(Comparator.comparing(Transaction::getValue).reversed()) // sort by value desc
                .map(Transaction::getId)                         // map to id
                .collect(Collectors.toList());                   // collect as list

        System.out.println(transactionIds); 

    }

    // Method to filter strings of a given length and convert them to uppercase
    private static List<String>
    filterAndConvertToUpper(Stream<String> stream, int length)
    {
        return stream.filter(s -> s.length() == length)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }
    

}

/*
 There are two methods to create parallel streams are mentioned below:

Using the parallel() method on a stream
Using parallelStream() on a Collection
*/

/*
Java provides specialized streams for primitive data types:

IntStream -> for int values
LongStream -> for long values
DoubleStream -> for double values

*/
