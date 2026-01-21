package OOPS;

class Animal {
    void eat(){
        System.out.println("Animal Eating ....");
    }
    void sound() {
        System.out.println("Animal makes a sound");
    }
    void sleep(){
        System.out.println("Sleeping ...");
    }
}

// Child class
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Child class
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Child class
class Cow extends Animal {
    @Override
    void sound() {
        System.out.println("Cow moos");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Dog myDog = new Dog();

        // Inherited methods (from Animal)
        myDog.eat();
        myDog.sleep();

        // Child class method
        myDog.sound();

        Cow holyCow=new Cow();
        holyCow.eat();
        holyCow.sleep();
        holyCow.sound();

        Animal myCat=new Cat();
        myCat.sleep();
        myCat.sound();
    }
}
