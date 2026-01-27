package Synchronization;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData{
    private final List<String> list = new ArrayList<>();
    private final ReadWriteLock rwLock
        = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    // Writer
    public void add(String value)
    {
        writeLock.lock();
        try {
            list.add(value);
            System.out.println(
                Thread.currentThread().getName()
                + " added: " + value);
        }
        finally {
            writeLock.unlock();
        }
    }

    // Reader
    public void read(int index)
    {
        readLock.lock();
        try {
            if (index < list.size()) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " read: " + list.get(index));
            }
        }
        finally {
            readLock.unlock();
        }
    }
}


class Worker implements Runnable {

    private ReentrantLock lock;
    private String name;

    Worker(ReentrantLock lock, String name)
    {

        this.lock = lock;
        this.name = name;
    }

    @Override public void run()
    {

        lock.lock(); // Acquire lock
        try {
            System.out.println(name + " acquired lock");
            Thread.sleep(1000); // Simulate work
            System.out.println(name + " finished work");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock(); // Release lock
        }
    }
}

public class LearnLocks {
    public static void main(String[] args){
        
        ReentrantLock lock = new ReentrantLock();

        Thread t1
            = new Thread(new Worker(lock, "Thread-1"));
        Thread t2
            = new Thread(new Worker(lock, "Thread-2"));

        t1.start();
        t2.start();

        SharedData data = new SharedData();

        // Writers
        Thread writer1
            = new Thread(() -> data.add("Hi"), "Writer-1");
        Thread writer2 = new Thread(
            () -> data.add("Hello"), "Writer-2");

        // Readers
        Thread reader1
            = new Thread(() -> data.read(0), "Reader-1");
        Thread reader2
            = new Thread(() -> data.read(1), "Reader-2");

        writer1.start();
        writer2.start();

        reader1.start();
        reader2.start();
    }
}

