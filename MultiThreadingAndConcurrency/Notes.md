# Multithreading in Java
Multithreading in Java is a feature that enables a program to run multiple threads simultaneously, allowing tasks to execute in parallel and utilize the CPU more efficiently. A thread is a lightweight, independent unit of execution inside a program (process).

* A process can have multiple threads.
* Each thread runs independently but shares the same memory.

## Creating a Thread
1. **Extending the Thread class: **
  We create a class that extends Thread and override its run() method to define the task. Then, we make an object of this class and call start(), which automatically calls run() and begins the thread’s execution.
2. **Implementing the Runnable Interface: **
We create a new class which implements java.lang.Runnable interface and define the run() method there. Then we instantiate a Thread object and call start() method on this object. 
---
* **Use extends Thread**: if your class does not extend any other class.
* **Use implements Runnable:** if your class already extends another class (preferred because Java doesn’t support multiple inheritance).

## Thread.start() VS Thread.run()

The start() method is used to begin a new thread of execution. It performs two main tasks:

* Allocates resources for a new thread.
* Calls the run() method internally in the new thread.

The run() method contains the code executed by the thread. However, calling run() directly does not create a new thread. Instead, it behaves like a normal method call executed in the current thread.

## LifeCycle of a Thread

During its thread life cycle, a Java thread transitions through several states from creation to termination.

* New State
* Runnable State
* Blocked State
* Waiting State
* Timed Waiting State
* Terminated State