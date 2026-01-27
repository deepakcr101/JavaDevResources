package Synchronization;

class A 
{
    synchronized void sum(int n)
    {
        // Creating a thread instance
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println(t.getName() + " : " + (n + i));
        }
    }
}

// Class B extending thread class
class B extends Thread 
{
    // Creating an object of class A
    A a = new A();
    public void run()
    {

        // Calling sum() method
        a.sum(10);
    }
}


public class LearnThreadSafety {

    // Initializing volatile variables a, b
    static volatile int a = 0, b = 0;

    // Defining a static void method
    static void method_one() {
        a++;
        b++;
    }

    // Defining static void method
    static void method_two() {
        System.out.println("a=" + a +
                           " b=" + b);
    }

    public static void main(String[] args)
    {
        // Creating an object of class B
        B b = new B();

        // Initializing instance t1 of Thread class with object of class B
        Thread t1 = new Thread(b);

        // Initializing instance t2 of Thread class with object of class B
        Thread t2 = new Thread(b);

        // Initializing thread t1 with name 'Thread A'
        t1.setName("Thread A");

        // Initializing thread t2 with name 'Thread B'
        t2.setName("Thread B");

        // Starting thread instance t1 and t2
        t1.start();
        t2.start();

        // Creating an instance t1 of Thread class
        Thread t3 = new Thread() 
        {
            public void run()
            {
                for (int i = 0; i < 5; i++)
                    method_one();
            }
        };

        // Creating an instance t2 of Thread class
        Thread t4 = new Thread() 
        {
            public void run()
            {
                for (int i = 0; i < 5; i++)
                    method_two();
            }
        };

        // Starting instance t1 and t2
        t3.start();
        t4.start();
    }
}
