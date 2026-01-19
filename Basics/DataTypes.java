// Interface
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Woof");
    }
}

// Car Class
class Car {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    void display() {
        System.out.println(model + " " + year);
    }
}

public class DataTypes {

    public static void main(String args[]) {
        // Premitive Data Types
        // boolean value used for true,false 0 or 1 Not JVM defined size
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Is fish tasty? " + isFishTasty);

        // byte 8bit signed integer 1byte size -128 to 127
        byte age = 25;
        byte temperature = -10;
        System.out.println("Age: " + age);
        System.out.println("Temperature: " + temperature);

        // short 2byte signed integer -32,768 to 32,767
        short students = 1000;
        short temp = -200;
        System.out.println("Students: " + students);
        System.out.println("Temperature: " + temp);

        // int 4bytes most commonly used numeric data -2,147,483,648 to 2,147,483,647
        int population = 2000000;
        int distance = 150000000;
        System.out.println("Population: " + population);
        System.out.println("Distance: " + distance);

        // long 8bytes used for larger values when int is nt suffice ±9.22e18
        long worldPopulation = 7800000000L;
        long lightYears = 9460730472580800L;
        System.out.println("World Population: " + worldPopulation);
        System.out.println("Light Years: " + lightYears);

        // decimal value Float Data 4 bytes(32bit) ~6–7 digits precision
        float pi = 3.14f;
        float gravity = 9.81f;
        System.out.println("Pi: " + pi);
        System.out.println("Gravity: " + gravity);

        // double default decimal values 8bytes(64bits) ~15–16 digits precision
        double pid = 3.141592653589793;
        double avogadro = 6.02214076e23;
        System.out.println("Pi: " + pid);
        System.out.println("Avogadro's Number: " + avogadro);

        // CHAR Datatype 16bit unicode characters used for single symbols and letters
        // 2bytes
        char grade = 'A';
        char symbol = '$';
        System.out.println("Grade: " + grade);
        System.out.println("Symbol: " + symbol);

        // Non-Primitive (Reference) Data Types
        // Non-primitive data types store references (memory addresses) rather than
        // actual values. They are created by users and include types like String,
        // Class, Object, Interface, and Array.

        // String sequence of characters enclosed within double quotes
        // immutable means we cant change
        String name = "Geek1";
        String message = "Welcome to Java";
        System.out.println("Name: " + name);
        System.out.println("Message: " + message);

        // class: a blueprint for creating objects its one of major concepts of OOPS
        Car myCar = new Car("Toyota", 2020);
        myCar.display();

        // Objects : Basic Foundation of OOPS it has
        // state(data),behaviour(methods),indentity(unique reference)
        Car myCar1 = new Car("Honda", 2021);
        System.out.println("Model: " + myCar1.model);
        System.out.println("Year: " + myCar1.year);

        // Interface: a blueprint for class basically a contract of abstract methods
        // that implementing classes must define. It provides a way to achieve
        // abstraction and multiple inheritance in Java.
        Animal dog = new Dog();
        dog.sound();

        // Array: a linear datastructure which store multiple values within same name
        // values stored at contigous locations
        // Java arrays are objects, dynamically allocated, and indexed from 0
        int[] numbers = { 1, 2, 3, 4, 5 };
        String[] names = { "Geek1", "Geek2", "Geek3" };
        System.out.println("First number: " + numbers[0]);
        System.out.println("Second name: " + names[1]);
    }
}