package CollectionsFramework;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class LearnLinkedList {
    public static void main(String[] args) {
        // Step 1: Create a LinkedList of integers
        LinkedList<Integer> numbers = new LinkedList<>();

        // Step 2: Add integers to the LinkedList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Step 3: Calculate the sum of all elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Step 4: Print the sum
        System.out.println("Sum of all elements: " + sum);

        // Step 1: Create a LinkedList of strings
        LinkedList<String> names = new LinkedList<>();

        // Step 2: Add strings to the LinkedList
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("Eve");

        // Step 3: Sort the LinkedList in alphabetical order
        Collections.sort(names);

        // Step 4: Print the sorted LinkedList
        System.out.println("Sorted names: " + names);

        // Step 1: Create a LinkedList of Person objects
        LinkedList<Person> people = new LinkedList<>();

        // Step 2: Add Person objects to the LinkedList
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 35));

        // Step 3: Iterate over the LinkedList and print each Person object
        for (Person person : people) {
            System.out.println(person);
        }

        // Step 1: Create two LinkedLists
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");
        list1.add("Date");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Banana");
        list2.add("Cherry");
        list2.add("Elderberry");
        list2.add("Fig");

        // Step 2: Find common elements
        LinkedList<String> commonElements = new LinkedList<>(list1);
        commonElements.retainAll(list2); // Retains only elements that are in both lists

        // Step 3: Print common elements
        System.out.println("Common elements: " + commonElements);

        // Step 1: Create a LinkedList with duplicate elements
        LinkedList<String> items = new LinkedList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Apple");
        items.add("Date");
        items.add("Banana");

        // Step 2: Remove duplicates using LinkedHashSet
        LinkedHashSet<String> uniqueItems = new LinkedHashSet<>(items);

        // Step 3: Convert back to LinkedList
        LinkedList<String> deduplicatedList = new LinkedList<>(uniqueItems);

        // Step 4: Print the LinkedList without duplicates
        System.out.println("Original list: " + items);
        System.out.println("List without duplicates: " + deduplicatedList);

    }
}

/*
 * Definition: LinkedList is a doubly-linked list implementation of the List and
 * Deque interfaces.
 * 
 * Key Features:
 * 
 * Allows duplicate elements.
 * 
 * Maintains insertion order.
 * 
 * Provides faster manipulation of elements compared to ArrayList (e.g.,
 * insertion, deletion) because it doesn't involve resizing.
 * 
 * Can act as a Queue or Deque (supports FIFO and LIFO operations).
 * 
 * 
 * 
 * Common Methods:
 * 
 * add(element): Adds an element to the list.
 * 
 * addFirst(element): Adds an element at the beginning.
 * 
 * addLast(element): Adds an element at the end.
 * 
 * remove(index): Removes an element at the specified index.
 * 
 * removeFirst(): Removes the first element.
 * 
 * removeLast(): Removes the last element.
 * 
 * get(index): Retrieves an element at the specified index.
 * 
 * getFirst(): Retrieves the first element.
 * 
 * getLast(): Retrieves the last element.
 * 
 * size(): Returns the number of elements in the list.
 * 
 */

// ARRAYLIST VS LINKEDLIST
/*
 * Performance:
 * 
 * 
 * 
 * ArrayList is faster for random access (get(index)).
 * 
 * LinkedList is faster for element insertion and deletion, especially at the
 * beginning or middle of the list.
 * 
 * 
 * 
 * Memory:
 * 
 * 
 * 
 * ArrayList uses a contiguous block of memory.
 * 
 * LinkedList uses nodes, which require more memory due to storage of references
 * (pointers).
 * 
 * 
 * 
 * Use Cases:
 * 
 * 
 * 
 * Use ArrayList when you need fast random access and minimal
 * insertion/deletion.
 * 
 * Use LinkedList when frequent insertion/deletion operations are required.
 * 
 */