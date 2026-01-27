package Synchronization;

import java.util.concurrent.atomic.AtomicInteger;

class Counter 
{
    // Creating a variable of class type AtomicInteger
    AtomicInteger count
        = new AtomicInteger();

    // Defining increment() method to change value of AtomicInteger variable
    public void increment() {
        count.incrementAndGet();
    }
}

public class TestCounter {
    public static void main(String[] args)
    {
        // Creating an instance of Counter class
        Counter c = new Counter();

        // Creating an instance t1 of Thread class
        Thread t1 = new Thread(new Runnable() 
        {
        	public void run() {
            	for(int i = 1; i <= 2000; i++) {
                	c.increment();
                }
            }
        });

        // Creating an instance t2 of Thread class
        Thread t2 = new Thread(new Runnable() 
        {
        	public void run() {
              	for (int i = 1; i <= 2000; i++) {
                  	c.increment();
                }
            }
        });

        // Calling start() method with t1 and t2
        t1.start();
        t2.start();

        // Calling join method with t1 and t2
        try{
            t1.join();
        t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(c.count);
    }
}