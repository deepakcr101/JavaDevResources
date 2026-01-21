package OOPS;

// Basic Interface
interface Animal {
    void eat(); // Abstract method

    void sleep(); // Abstract method
    
}

// Implementing an Interface
class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}

// Multiple Interfaces Implementation

interface Walkable {
    void walk();
}

interface Runnable {
    void run();
}

class Human implements Walkable, Runnable {
    @Override
    public void walk() {
        System.out.println("Human is walking.");
    }

    @Override
    public void run() {
        System.out.println("Human is running.");
    }
}

// Default Methods in Interface
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting.");
    }

    void stop(); // Abstract method
}

class Car implements Vehicle {
    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }
}

// STATIC METHOD IN INTERFACE
interface Calculator {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}

// PRIVATE METHODS IN INTERFACE
// Private methods help in reusing code inside default and static methods.
interface Logger {
    private void log(String message) {
        System.out.println("Log: " + message);
    }

    default void info(String message) {
        log("INFO: " + message);
    }

    default void error(String message) {
        log("ERROR: " + message);
    }
}

class AppLogger implements Logger {
}

//Interface Inheritance
interface Shape {
    void draw();
}

interface ColoredShape extends Shape {
    void color();
}

class Circle implements ColoredShape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }

    @Override
    public void color() {
        System.out.println("Coloring the circle.");
    }
}

//Marker Interfaces
//Marker interfaces are empty interfaces used to indicate metadata
interface Serializable {}

class Data implements Serializable {
    void processData() {
        System.out.println("Processing data.");
    }
}

// Functional Interfaces (Lambda Expressions)

// Functional interfaces have a single abstract method and are used with lambda expressions.
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}


// Nested Interfaces

// Interfaces can be declared inside classes or other interfaces.
class OuterClass {
    interface NestedInterface {
        void display();
    }
}

class Implementation implements OuterClass.NestedInterface {
    @Override
    public void display() {
        System.out.println("Nested interface implemented.");
    }
}



public class LearnInterface {
    public static void main(String args[]) {
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();

        Human human = new Human();
        human.walk();
        human.run();

        Car car = new Car();
        car.start(); // Default method
        car.stop(); // Abstract method

        System.out.println("Addition: " + Calculator.add(5, 3));
        System.out.println("Subtraction: " + Calculator.subtract(5, 3));

        AppLogger logger = new AppLogger();
        logger.info("Application started.");
        logger.error("An error occurred.");

        Circle circle = new Circle();
        circle.draw();
        circle.color();

        Data data = new Data();
        if (data instanceof Serializable) {
            System.out.println("Data is serializable.");
        }
        data.processData();

        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!");
        greeting.sayHello("Alice");

        OuterClass.NestedInterface obj = new Implementation();
        obj.display();

    }
}

// variables are public static final by default.

// Private methods can only be called inside default or static methods.
// Static methods are accessed using the interface name, not via objects.
// To implement an interface, use the implements keyword.
// static methods are called directly using the interface name and are not
// inherited by implementing classes.