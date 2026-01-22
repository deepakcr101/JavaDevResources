package CollectionsFramework;

//import java.io.*;
//import java.util.*;
import java.util.Stack;

//Stacks are not suitable for random access or large datasets due to their linear nature.

public class LearnStack {
    public static void main(String[] args) {
        // Step 1: Create a stack
        Stack<Integer> stack = new Stack<>();

        // Step 2: Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(100);

        System.out.println("Stack after push operations: " + stack);

        // Step 3: Peek the top element
        System.out.println("Top element (peek): " + stack.peek());

        // Step 4: Pop an element from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop operation: " + stack);

        // Step 5: Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Step 6: Search for an element
        int position = stack.search(20); // Returns position from the top (1-based index)
        if (position != -1) {
            System.out.println("Element 20 found at position: " + position);
        } else {
            System.out.println("Element 20 not found in the stack.");
        }

        // APPLICATIONS OF STACK
        printReverseString("Rahul Batra");

        String expression = "{[(a+b)*(c-d)]}";
        System.out.println("Expression: " + expression);
        System.out.println("Is balanced? " + isBalanced(expression));

        expression = "53+82-*"; // Postfix expression
        System.out.println("Postfix Expression: " + expression);
        System.out.println("Result: " + evaluatePostfix(expression));

        // sorting without using any extra datastructures
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);

    }

    private static void printReverseString(String input) {
        System.out.println("Original String: " + input);

        // Step 1: Create a stack
        Stack<Character> stack = new Stack<>();

        // Step 2: Push all characters of the string onto the stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Step 3: Pop characters from the stack to reverse the string
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        // Output the reversed string
        System.out.println("Reversed String: " + reversedString);

    }

    // balanced parenthesis
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Push opening brackets onto the stack
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // Check if stack is empty or top element doesn't match
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, parentheses are balanced
        return stack.isEmpty();
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to integer
            } else {
                // Pop two operands
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Perform the operation
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // Final result is the top of the stack
        return stack.pop();
    }

    // sorting stack without using extra data structures
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Remove the top element
            int temp = stack.pop();

            // Step 2: Sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the element in sorted order
            insertSorted(stack, temp);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }

}

// # a Stack is a linear data structure that follows the Last In First Out
// (LIFO) principle and is defined in the java.util package. Internally, it
// extends the Vector class.

/*
 * Stack class maintains insertion order and allows duplicates and null values.
 * Grows dynamically when its capacity is exceeded.
 * All the methods of Stack are synchronized. It is thread-safe.
 * Stack is considered a legacy class, introduced in early versions of Java and
 * a preferred solution to implement Stack Data Structure (especially when
 * thread synchronization is not needed) is either to use ArrayDeque or
 * LinkedList
 * Stack class implements List, RandomAccess, Cloneable, and Serializable
 * interfaces.
 * 
 */

/*
 * Common Operations:
 * 
 * 
 * 
 * Push: Adds an element to the top of the stack.
 * 
 * Pop: Removes and returns the top element of the stack.
 * 
 * Peek: Retrieves the top element without removing it.
 * 
 * isEmpty: Checks if the stack is empty.
 * 
 * Search: Returns the position of an element (distance from the top of the
 * stack).
 * 
 */
