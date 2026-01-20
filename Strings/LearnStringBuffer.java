package Strings;

public class LearnStringBuffer {
    public static void main(String args[]) {
        // Creating StringBuffer
        StringBuffer s = new StringBuffer();

        // Adding elements in StringBuffer
        s.append("Hello");
        s.append(" ");
        s.append("world");

        // String with the StringBuffer value
        String str = s.toString();
        System.out.println(str);

        // 1. Using default constructor
        StringBuffer sb1 = new StringBuffer();
        sb1.append("Hello");
        System.out.println("Default Constructor: " + sb1);

        // 2. Using constructor with specified capacity
        StringBuffer sb2 = new StringBuffer(50);
        sb2.append("Java Programming");
        System.out.println("With Capacity 50: " + sb2);

        // 3. Using constructor with String
        StringBuffer sb3 = new StringBuffer("Welcome");
        sb3.append(" to Java");
        System.out.println("With String: " + sb3);

        // StringBuffer Methods
        StringBuffer sb = new StringBuffer("Java is Fun");
        sb.insert(1, "Java");

        // Now original string is changed
        System.out.println(sb);

        sb.replace(1, 3, "Java");
        System.out.println(sb);

        sb.delete(1, 3);
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        // default 16
        System.out.println(sb.capacity());
        sb.append("Hello");

        // now 16
        System.out.println(sb.capacity());
        sb.append("java is my favourite language");

        // (oldcapacity*2)+2
        System.out.println(sb.capacity());

        int p = sb.length();

        // Getting the capacity of the string
        System.out.println("Length of stringbuffer = " + p);

    }
}

// ThreadSafe StringBuilder