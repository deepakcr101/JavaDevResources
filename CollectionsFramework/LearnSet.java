package CollectionsFramework;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

//HashSet is not thread-safe. To make it thread-safe, synchronization is needed externally.

public class LearnSet {
    public static void main(String[] args) {
        // Create a Set using HashSet
        Set<String> s = new HashSet<>();

        // Displaying the Set
        System.out.println("Set Elements: " + s);

        s.add("B");
        s.add("B");
        s.add("C");
        s.add("A");

        System.out.println(s);

        String str = "D";

        System.out.println("Contains " + s + " " + s.contains(str));

        // Declaring object of Set of type String
        Set<String> h = new HashSet<String>();

        // Elements are added using add() method, Custom input elements
        h.add("A");
        h.add("B");
        h.add("C");
        h.add("B");
        h.add("D");
        h.add("E");
        
        System.out.println("Initial HashSet " + h);

        // Removing custom element using remove() method
        h.remove("B");
        System.out.println("After removing element " + h);

        // Iterating through the Set via for-each loop 
        for (String value : h)

            // Printing all the values inside the object 
            System.out.print(value + ", ");
        
        System.out.println();

        // Creating an empty Set
        Set<String> set = new HashSet<String>();

        // Use add() method to add elements into the Set
        set.add("Welcome");
        set.add("To");
        set.add("Ciena");
        set.add("4");
        set.add("BluePlanet");

        // Displaying the Set
        System.out.println("Set: " + set);

        // Creating an iterator
        Iterator value = set.iterator();

        // Displaying the values after iterating through the iterator
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }

    }
}


/*
Classes that implement the Set interface
 # HashSet: A set that stores unique elements without any specific order, using a hash table and allows one null element.
# EnumSet : A high-performance set designed specifically for enum types, where all elements must belong to the same enum.
# LinkedHashSet: A set that maintains the order of insertion while storing unique elements.
# TreeSet: A set that stores unique elements in sorted order, either by natural ordering or a specified comparator.

*/