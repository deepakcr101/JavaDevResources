package Strings;

import java.util.Scanner;
import java.lang.String;

public class LearnStrings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = "Deepak Kumar";
        System.out.println(str);

        String a = new String("deepak");
        String b = new String("deepak");
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String num1 = "45";
        String num2 = "55";
        System.out.println(num1 + num2);

        // Immutability of Strings
        String s = "Sachin";

        // concat() method appends the string at the end
        s.concat(" Tendulkar");

        // This will print Sachin because strings are immutable objects
        System.out.println(s);

        System.out.println("Enter First Name: ");
        String firstName = sc.next();
        System.out.println("Enter Last Name: ");
        String lastName = sc.next();

        String fullName = firstName.concat(lastName);
        System.out.println(fullName);

        // ASCI
        // Creating Byte ASCII Array
        byte ascii[] = { 65, 66, 67 };

        // Creating String using byte array
        String firstString = new String(ascii);
        System.out.println(firstString);

        // Creating String using byte array with Start index to End Index
        String secondString = new String(ascii, 1, 2);
        System.out.println(secondString);

        // Character Array
        char characters[] = { 'A', 'B', 'C' };

        // Creating new String using Character Array
        firstString = new String(characters);

        // Creating new String using another String
        secondString = new String(firstString);

        System.out.println(firstString);
        System.out.println(secondString);

        // String Methods
        str = "HereForJavaFun";

        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Substring: " + str.substring(2, 6));

        System.out.println(str.charAt(5));

        // substring from st idx
        System.out.println(str.substring(4));

        // from to
        System.out.println(s.substring(3, 5));

        System.out.println(s.concat("!!!"));

        System.out.println(s.indexOf("For"));

        System.out.println(str.indexOf("n", 4));

        System.out.println(s.lastIndexOf("e"));

        System.out.println(s.equalsIgnoreCase("hereforjavafun"));

        // lexicographic comparison
        System.out.println(s.compareTo(str));

        System.out.println(s.compareToIgnoreCase("sachin"));
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());

        String str1 = " Mahender Singh Dhoni  ";
        System.out.println("'" + str1.trim() + "'");
        System.out.println(str1.replace('e', 'a'));
        System.out.println(str.contains("Sing"));

        char[] chars = str.toCharArray();
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println(s.startsWith("Ram"));

        // Constructor 1: Creating string using new keyword
        str1 = new String("Hello Java");
        System.out.println("String using new keyword: " + str1);

        // Constructor 2: Creating string from character array
        char[] charArray = { 'J', 'A', 'V', 'A' };
        String str2 = new String(charArray);
        System.out.println("String from char array: " + str2);

        // Constructor 3: Creating string from byte array
        byte[] byteArray = { 72, 101, 108, 108, 111 };
        String str3 = new String(byteArray);
        System.out.println("String from byte array: " + str3);

        sc.close();
    }
}

/*
 * a String represents a sequence of characters used for storing and
 * manipulating text. It is immutable and provides many built-in methods for
 * operations like concatenation, comparison, and manipulation.
 */
