package OOPS;

// Parent Class
class Parent {
    // Overloaded method (compile-time polymorphism)
    public void func() {
        System.out.println("Parent.func()");
    }

    // Overloaded method (same name, different parameter)
    public void func(int a) {
        System.out.println("Parent.func(int): " + a);
    }
}

// Child Class
class Child extends Parent {
    // Overrides Parent.func(int) (runtime polymorphism)
    @Override
    public void func(int a) {
        System.out.println("Child.func(int): " + a);
    }
}

public class LearnPolymorphism {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        // Dynamic dispatch
        Parent polymorphicObj = new Child();

        // Method Overloading (compile-time)
        parent.func();
        parent.func(10);

        // Method Overriding (runtime)
        child.func(20);

        // Polymorphism in action
        polymorphicObj.func(30);
    }
}

// Runtime Polymorphism in Java is also known as dynamic method dispatch
// It occurs when a method call is resolved at runtime, and it is achieved using
// method overriding.

// At runtime, the method that gets executed depends on the actual object type,
// not the reference type.
