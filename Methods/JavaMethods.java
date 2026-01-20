package Methods;

/*Java Methods are blocks of code that perform a specific task. A method allows us to reuse code, improving both efficiency and organization. All methods in Java must belong to a class. Methods are similar to functions and expose the behavior of objects. */

/*
 Parts of a function declaration:
  access modifiers: private,protected,default,public
  return typr
  name of function camelCase
  () arguments inside parentheses
   return (optional if void return type)
   body
*/

class Test {
    static void hello() {
        System.out.println("Hello");
    }
}

public class JavaMethods {
    // Breaking code into separate methods helps improve readability, reusability,
    // and maintainability

    public static void D() {
        float d = 40.5f;
        System.out.println("In Method D " + d + " ");
    }

    public static void C() {
        double c = 30.5;
        System.out.println("In Method C " + c + " ");
    }

    public static void B() {
        int b = 20;
        C(); // Calling C
        System.out.println("In Method B " + b + " ");
    }

    public static void A() {
        int a = 10;
        B(); // Calling B
        System.out.println("In Method A " + a + " ");
    }

    public static void main(String args[]) {
        A(); // Start with function A
        D(); // Then call D

        JavaMethods obj = new JavaMethods();
        System.out.println(obj.hashCode());

        Test.hello(); // Call static method directly
    }

}

// Java is an object-oriented and stack-based programming language

// CALL stack
// The call stack is a data structure used by the program during runtime to
// manage method calls and local variables. It operates in a Last-In-First-Out
// (LIFO) manner, meaning the last method called is the first one to complete
// and exit.
