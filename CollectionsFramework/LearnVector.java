package CollectionsFramework;

import java.util.Vector;

//Thread-safe: All methods are synchronized for safe multi-threaded access.
//ArrayList is preferred over vector in general when in-built thread synchronization is not required

public class LearnVector {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("A");
        v.add("B");
        v.add("C");
        System.out.println(v);

        Vector<Integer> vector = new Vector<>(2); // initial capacity = 2
        System.out.println("Initial capacity: " + vector.capacity());

        // Add elements to trigger capacity increase
        vector.add(10);
        vector.add(20);
        System.out.println("Capacity after adding 2 elements: " + vector.capacity());

        vector.add(30); // Triggers resize (2 → 4)
        System.out.println("Capacity after adding 3rd element: " + vector.capacity());

        vector.add(40);
        vector.add(50); // Triggers resize again (4 → 8)
        System.out.println("Capacity after adding 5 elements: " + vector.capacity());

        // Creating a default vector
        Vector v1 = new Vector();

        // Adding custom elements using add() method
        v1.add(1);
        v1.add(2);
        v1.add("geeks");
        v1.add("forGeeks");
        v1.add(3);

        System.out.println("Vector v1 is " + v1);

        // Creating generic vector
        Vector<Integer> v2 = new Vector<Integer>();

        // Adding custom elements using add() method
        v2.add(1);
        v2.add(2);
        v2.add(3);

        System.out.println("Vector v2 is " + v2);
    }
}
