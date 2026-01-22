package CollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

//Not Synchronized: ArrayList is not thread-safe. To make it thread-safe, you must wrap it manually using Collections.synchronizedList()

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

public class LearnArrayList {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Step 2: Add elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        // Step 3: Print the ArrayList
        System.out.println("Fruits List: " + fruits);

        // Step 4: Access elements using index
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Second fruit: " + fruits.get(1));

        // Step 5: Remove an element
        fruits.remove(2); // Removes "Cherry"
        System.out.println("After removing Cherry: " + fruits);

        // Step 6: Check if an element exists
        if (fruits.contains("Apple")) {
            System.out.println("Apple is in the list.");
        } else {
            System.out.println("Apple is not in the list.");
        }

        // Step 7: Get the size of the ArrayList
        System.out.println("Size of the list: " + fruits.size());

        // Step 8: Iterate over the ArrayList
        System.out.println("Iterating over the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Step 9: Clear the ArrayList
        fruits.clear();
        System.out.println("After clearing: " + fruits);
        System.out.println("Is the list empty? " + fruits.isEmpty());

        // sum
        // Step 1: Create an ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Step 2: Add integers to the ArrayList
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

        // Step 1: Create an ArrayList of strings
        ArrayList<String> names = new ArrayList<>();

        // Step 2: Add strings to the ArrayList
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("Eve");

        // Step 3: Sort the ArrayList in alphabetical order
        Collections.sort(names);

        // Step 4: Print the sorted ArrayList
        System.out.println("Sorted names: " + names);

        // Step 1: Create an ArrayList of Person objects
        ArrayList<Person> people = new ArrayList<>();

        // Step 2: Add Person objects to the ArrayList
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 35));

        // Step 3: Iterate over the ArrayList and print each Person object
        for (Person person : people) {
            System.out.println(person);
        }

        // Step 1: Create two ArrayLists
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");
        list1.add("Date");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Banana");
        list2.add("Cherry");
        list2.add("Elderberry");
        list2.add("Fig");

        // Step 2: Find common elements
        ArrayList<String> commonElements = new ArrayList<>(list1);
        commonElements.retainAll(list2); // Retains only elements that are in both lists

        // Step 3: Print common elements
        System.out.println("Common elements: " + commonElements);


        // Step 1: Create an ArrayList with duplicate elements
        ArrayList<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Apple");
        items.add("Date");
        items.add("Banana");

        // Step 2: Remove duplicates using LinkedHashSet
        LinkedHashSet<String> uniqueItems = new LinkedHashSet<>(items);

        // Step 3: Convert back to ArrayList
        ArrayList<String> deduplicatedList = new ArrayList<>(uniqueItems);

        // Step 4: Print the ArrayList without duplicates
        System.out.println("Original list: " + items);
        System.out.println("List without duplicates: " + deduplicatedList);

    }
}

/*
The ArrayList class is versatile and can be used for various tasks like summing elements, sorting, and finding common elements.

Collections.sort() is a utility method to sort lists.

Custom objects (Person class) can be stored and iterated in an ArrayList.

Use retainAll() to find common elements between two lists.

Utilize LinkedHashSet to remove duplicates while maintaining insertion order.
*/
