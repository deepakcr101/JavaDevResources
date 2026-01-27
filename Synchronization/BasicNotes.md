# Synchronization in Java 
It is a mechanism that ensures that only one thread can access a shared resource (like a variable, object, or method) at a time. It prevents concurrent threads from interfering with each other while modifying shared data.

## Why is Synchronization Needed?
* **Prevents Data Inconsistency:** Ensures that multiple threads don’t corrupt shared data when accessing it simultaneously.
* **Avoids Race Conditions:** Allows only one thread to execute a critical section at a time, maintaining predictable results.
* **Maintains Thread Safety:** Protects shared resources from concurrent modification by multiple threads.
* **Ensures Data Integrity:** Keeps shared data accurate and consistent throughout program execution.

## Ways to Achieve Synchronization:
1. Synchronized Methods
A synchronized method ensures that only one thread can execute it at a time on the same object instance
2. Synchronized Blocks
Instead of synchronizing an entire method, Java allows synchronization on specific blocks of code. This improves performance by locking only the necessary section.
3.  Static Synchronization
Static synchronization is used to synchronize static methods. In this case, the lock is placed on the class object rather than the instance.

### Thread Synchronization in Java
Thread Synchronization is used to coordinate and ordering of the execution of the threads in a multi-threaded program. There are two types of thread synchronization are mentioned below:

* Mutual Exclusive
* Cooperation (Inter-thread communication in Java)

### Volatile Keyword
The volatile keyword in Java ensures that all threads have a consistent view of a variable's value. It prevents caching of the variable's value by threads, ensuring that updates to the variable are immediately visible to other threads.

Working of Volatile Modifier:

* It applies only to variables.
* volatile guarantees visibility i.e. any write to a volatile variable is immediately visible to other threads.
* It does not guarantee atomicity, meaning operations like count++ (read-modify-write operations) can still result in inconsistent values

## Atomic Variable
Using an atomic variable is another way to achieve thread-safety in java. When variables are shared by multiple threads, the atomic variable ensures that threads don't crash into each other. 

## Locks
It controls access to shared resources, ensuring thread safety. Some locks, like

* Exclusive Lock(ReentrantLock): Only one thread can acquire the lock at a time.
* Shared Lock(ReadWriteLock): Multiple threads can hold the lock simultaneously under certain conditions.

```
Lock lock = new ReentrantLock();
lock.lock();   // Acquire the lock
// Critical section
lock.unlock(); // Release the lock
```

---
1. ReentrantLock
A ReentrantLock() is an implementation of Lock that allows a thread to reacquire the lock it already holds.

2.  ReadWriteLock
A ReadWriteLock allows multiple threads to read a resource concurrently, but only one thread to write, ensuring no reads happen during writing.

## Monitor in Java
a Monitor is a synchronization construct that controls access to shared resources among multiple threads. Every Java object can act as a monitor.

## Lock in Java
Lock is a tool for controlling access to shared resources by multiple threads. It’s part of the java.util.concurrent.locks package, introduced in Java 5 and is an alternative to the traditional synchronized keyword.

```
As monitors themselves are implemented with the necessary support of locks, it is often said that they are not different but complementary in their existence.
```
### Rule of Thumb: For simple scenarios, synchronized is enough. For scalable, complex multi-threading, prefer Lock framework.

## Thread Pool in Java
Last Updated : 1 Sep, 2025
A Thread Pool is a collection of pre-created, reusable threads that are kept ready to perform tasks. Instead of creating a new thread every time you need to run something (which is costly in terms of memory and CPU), a thread pool maintains a fixed number of threads. When a task is submitted:

* If a thread is free, it immediately picks up the task and runs it.
* If all threads are busy, the task waits in a queue until a thread becomes available.
* After finishing a task, the thread does not die. It goes back to the pool and waits for the next task.