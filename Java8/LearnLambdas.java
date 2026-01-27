package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

interface Add{
    int addition(int a,int b);
}

@FunctionalInterface
interface FuncInterface{
    
    void abstractFun(int x);
    default void normalFun(){
        System.out.println("Hello");
        }
}

@FunctionalInterface
interface ZeroParameter{
    
    void display();
}

@FunctionalInterface
interface Functional {
    int operation(int a, int b);
}

class MathUtil{
    static void square(int n) {
        System.out.println(n * n);
    }
}

class Printer{
    void print(String msg) {
        System.out.println(msg);
    }
}

class Student {
    Student() {
        System.out.println("Student object created");
    }
}

public class LearnLambdas {
    public static void main(String[] args) {
        // Lambda expression to add two numbers
        Add add = (a, b) -> a + b;
        
        int result = add.addition(10, 20);
        System.out.println("Sum: " + result);
        FuncInterface fobj = (int x) -> System.out.println(2 * x);
        fobj.abstractFun(5);

        // Lambda expression with zero parameters
        ZeroParameter zeroParamLambda = ()
            -> System.out.println(
                "This is a zero-parameter lambda expression!");

        // Invoke the method
        zeroParamLambda.display();

        //one parameter
        //It is not mandatory to use parentheses if the type of that variable can be inferred from the context.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("All elements:");
        list.forEach(n -> System.out.println(n));

        System.out.println("Even elements:");
        list.forEach(n -> {
            if (n % 2 == 0)
                System.out.println(n);
        });
        //The forEach() method internally uses the Consumer<T> functional interface, which takes one argument and performs an action.


        // Using lambda expressions to define the operations
        Functional add1 = (a, b) -> a + b;
        Functional multiply = (a, b) -> a * b;

        // Using the operations
        System.out.println(add1.operation(6, 3));  
        System.out.println(multiply.operation(4, 5)); 
        // Lambda expressions are just like functions and they accept parameters just like functions.


        //use in collections
        List<String> names = Arrays.asList(
            "Alice", "Bob", "Charlie", "Adam");

        System.out.println("All names:");
        names.forEach(name -> System.out.println(name));

        System.out.println("\nNames starting with 'A':");
        names.stream()
            .filter(n -> n.startsWith("A"))
            .map(n -> n.toUpperCase())
            .forEach(System.out::println);

        
            //MethodReferences
         

        // Using method reference to print each name
        String[] namesArr=new String[names.size()];
        for(int i=0;i<names.size();i++) namesArr[i]=names.get(i);
        Arrays.stream(namesArr).forEach(LearnLambdas::print);
        
        //static method reference
        List<Integer> list1 = Arrays.asList(2, 3, 4);
        list1.forEach(MathUtil::square);

        //instance method reference
        Printer printer = new Printer();
        List<String> data = Arrays.asList("Java", "Spring", "Boot");

        data.forEach(printer::print); 


        //Reference to an Instance Method of an Arbitrary Object
         List<String> names1 = Arrays.asList("java", "spring", "microservice");

        names1.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

        //Reference to a Constructor

        Supplier<Student> supplier = Student::new;
        supplier.get();
    }

    // Method
    public static void print(String s){
        System.out.println(s);
    }

}

//allow developers to write concise, functional-style code by representing anonymous functions

//static method reference : ClassName::staticMethodName
//ex  : 
