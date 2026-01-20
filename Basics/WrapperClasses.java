//Java provides wrapper classes for all eight primitive data types to support object-based operations.

//AutoBoxing: automatically converting premitive to Wrapper Data Types

/*
Wrapper classes are required in Java for the following reasons:

Java collections (ArrayList, HashMap, etc.) store only objects, not primitives.
Wrapper objects allow primitives to be used in object-oriented features like methods, synchronization, and serialization.
Objects support null values, while primitives do not.
Wrapper classes provide utility methods such as compareTo(), equals(), and toString().
*/

import java.util.ArrayList;

public class WrapperClasses {
    public static void main(String args[]){
       int b = 357;
        // Autoboxing: primitive int -> Integer object
        Integer a = b;

        System.out.println("The primitive int b is: " + b);
        System.out.println("The Integer object a is: " + a);

        char ch = 'a';

        // Autoboxing: char -> Character
        Character c = ch;

        ArrayList<Integer> list = new ArrayList<>();
        // Autoboxing: int -> Integer
        list.add(25);
        System.out.println(list.get(0));

        c = 'a';
        // Unboxing: Character -> char
        ch = c;

        list = new ArrayList<>();
        list.add(24);
        // Unboxing: Integer -> int
        int num = list.get(0);

        System.out.println(num);

    }
}

/*
wrapper classes allow primitive data types to be represented as objects. This enables primitives to be used in object-oriented features such as collections, generics, and APIs that require objects.
*/
