
## **SECTION 1: Concurrency Fundamentals**

### **1. Threads vs Processes**
#### **Definition**
- **Process**: An independent program in execution.  
  Has its own memory space, system resources, and runs on its own.
- **Thread**: A smaller unit of execution within a process.  
  Multiple threads share the **same memory space** but execute independently.

#### **Key Differences**  
| Feature       | Process                      | Thread                          |
|---------------|------------------------------|----------------------------------|
| Memory        | Own memory space              | Shared memory within process     |
| Overhead      | High (needs context switching)| Low                             |
| Communication | IPC (Inter-Process Communication) | Shared variables                |
| Creation      | Slow                          | Faster                          |

#### **Example**
```java
// Process Example: Running two .jar files from command line creates two processes
// Thread Example: In the same Java program, starting multiple threads [below]
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
```

**Exercise:**
1. Write a program with two threads printing numbers from 1–10, and see how interleaving happens.
2. Start two separate processes (two Java classes with `main()`) and observe different memory usage.

---

### **2. Thread Class, Runnable Interface, Callable**
#### **Thread Class**
- Inherit from `Thread`, override `run()` method  
- Use `start()` to begin execution

#### **Runnable Interface**
- Implement `Runnable`, override `run()`  
- Passed to `Thread` constructor

#### **Callable Interface**
- Similar to `Runnable` but **returns a value** and can throw checked exceptions
- Used with `ExecutorService` and `Future`

#### **Why use each:**
- **Thread**: Simple, but limited (cannot extend other class)
- **Runnable**: Flexible, preferred for reusability & separation of task from thread mechanics
- **Callable**: When you need a **result** or to handle exceptions directly

#### **Example: Runnable vs Callable**
```java
// Runnable
class TaskRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable task executed");
    }
}

// Callable
class TaskCallable implements Callable<String> {
    public String call() throws Exception {
        return "Callable result";
    }
}

public class InterfaceDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new TaskRunnable());
        t.start();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new TaskCallable());
        System.out.println(future.get());  // blocks until result
        executor.shutdown();
    }
}
```

**Exercise:**
- Create a `Callable` that computes factorial of a given number.
- Compare performance of `Thread` vs `Executor` with multiple tasks.

---

### **3. Runnable vs Callable**
| Feature       | Runnable                    | Callable                        |
|---------------|-----------------------------|---------------------------------|
| Return value  | No                           | Yes                             |
| Exceptions    | Can't throw checked exceptions | Can                              |
| Added in      | Java 1.0                     | Java 5                          |

---

### **4. Futures**
- Represents a result of an asynchronous computation
- You can **check if it’s done**, **cancel**, or **get** the result.
- `Future.get()` blocks until result available.

---

### **5. Exceptions in Threads**
- Exceptions thrown in child threads **don’t propagate** to parent thread automatically.
- To handle gracefully:
    - Surround `run()` or `call()` with try-catch
    - Use `Thread.setUncaughtExceptionHandler`

```java
Thread t = new Thread(() -> {
    throw new RuntimeException("Test exception");
});
t.setUncaughtExceptionHandler((thread, throwable) -> {
    System.out.println("Caught exception: " + throwable.getMessage());
});
t.start();
```

---

### **6. Executors & CompletableFuture**
#### Executors:
- Framework for managing thread pools
- Avoid manual thread creation
- `ExecutorService`—submit tasks rather than manually run threads

#### CompletableFuture:
- Non-blocking, chaining of tasks
- Handles async processing elegantly

```java
CompletableFuture.supplyAsync(() -> "Hello")
    .thenApply(str -> str + " World")
    .thenAccept(System.out::println);
```

**Exercise:**  
- Use `CompletableFuture` to read data from two APIs in parallel and merge results.

---

### **7. Sleep, Wait, Notify, NotifyAll**
- **sleep(ms)**: Pause thread, still holds lock (if locked)
- **wait()**: Release lock and wait for notify
- **notify()**: Wake one waiting thread
- **notifyAll()**: Wake all waiting threads

---

### **8. Critical Section & Synchronization**
- **Critical section**: Part of code where shared data is accessed — must protect from race conditions
- Use `synchronized` blocks, `Lock` objects
```java
synchronized (this) {
    count++;
}
```

**Exercise:**
- Create program that increments shared counter from multiple threads with and without synchronization.

---

### **9. Generic Types**
- Allows parameterized types — reduces casting
```java
class Box<T> {
    private T content;
    public void set(T content) { this.content = content; }
    public T get() { return content; }
}
```

---

## **SECTION 2: Thread Pool & Lifecycle**

### **1. Thread Pool Lifecycle**
- **Creation** → **Assignment** → **Execution** → **Termination**
- Pool size fixed or variable
- Executors manage lifecycle automatically

---

### **2. Usage**
- Submit tasks instead of creating threads manually
- Improves performance for repeated tasks

---

### **3. Cached vs Fixed ThreadPool**
| Type            | Description                                         | Use Case        |
|-----------------|-----------------------------------------------------|-----------------|
| FixedThreadPool | Fixed number of threads                              | Steady workload |
| CachedThreadPool| Creates new threads as needed, reuses idle threads   | Short-lived tasks|

```java
ExecutorService fixed = Executors.newFixedThreadPool(3);
ExecutorService cached = Executors.newCachedThreadPool();
```

---

**Exercises:**
1. Implement fixed thread pool for processing list of numbers.
2. Use cached thread pool for handling multiple quick tasks.

---

## **ExecutorService Overview**
### **What is ExecutorService?**
- Part of the **java.util.concurrent** package.
- An abstraction for **asynchronous task execution**.
- Removes the need to manually:
  - Create threads  
  - Start them  
  - Manage lifecycle  
- You submit **tasks** (`Runnable` or `Callable`), and ExecutorService assigns them to threads in a pool.

### **Why use it?**
- **Performance**: Thread creation is expensive; reuse threads.  
- **Control**: Manage thread lifecycle centrally.  
- **Flexibility**: Configure thread numbers, scheduling.

---

## **Thread Pools**
### **Thread Pool = group of worker threads**
- Maintained by ExecutorService
- Threads are reused — once a task finishes, the thread is ready for another task
- Improves responsiveness and reduces overhead

### **Types of Thread Pools**
1. **Fixed Thread Pool**
   - Constant number of threads  
   - If all threads are busy, new tasks wait in queue  
   - Ideal for *steady workloads*
   
2. **Cached Thread Pool**
   - Creates new threads as needed, but reuses previously created threads when available  
   - Threads idle for **60 seconds** are terminated  
   - Ideal for *burst workloads* with short-lived tasks

---

### **Fixed Thread Pool Example**
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 threads
        
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running on " +
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed.");
            });
        }
        
        executor.shutdown(); // graceful shutdown after tasks finish
    }
}
```
**Key Observations:**
- Only **3 threads** process tasks at a time  
- Task queue ensures no task is lost  
- `shutdown()` waits for all tasks to finish

---

### **Cached Thread Pool Example**
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running on " +
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // simulate quick jobs
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed.");
            });
        }
        
        executor.shutdown();
    }
}
```
**Key Observations:**
- Creates threads dynamically for burst demand  
- Suitable for **short-lived tasks**  
- Idle threads terminate automatically after 60 seconds  

---

### **Choosing Between Fixed and Cached Thread Pools**
| Feature | Fixed Thread Pool | Cached Thread Pool |
|---------|------------------|--------------------|
| Thread count | Constant | Dynamic |
| Workload type | Steady, long-running | Short-lived, burst |
| Queue | Tasks wait if all busy | No queue, new threads created |
| Memory usage | Predictable | Variable |

---

## **Thread Pool Lifecycle**
1. **Creation** (`Executors.newFixedThreadPool()`, `Executors.newCachedThreadPool()`)
2. **Task Submission** (`execute()` or `submit()`)
3. **Execution**: Worker threads pick tasks from queue
4. **Completion**: Threads return to pool
5. **Shutdown**: Graceful or immediate termination

---

## **Best Practices**
- Always call `shutdown()` after task submission is complete  
- Use `awaitTermination()` for blocking shutdown  
- Handle exceptions inside tasks to avoid silent failures  
- For large-scale systems, consider `ThreadFactory` for naming threads  
- Monitor thread pool with `ThreadPoolExecutor` methods

---

### **Exercise: Practice with Thread Pools**
**Goal:** Build a program to process a list of URLs concurrently.
1. Use **FixedThreadPool** to fetch data from 5 URLs simultaneously.
2. Use **CachedThreadPool** for sudden bursts of requests and compare performance.
3. Measure:
   - Time taken  
   - Thread names used  
4. Handle exceptions gracefully in tasks.

---

## **CompletableFuture Deep Dive**
### **Purpose**
- Introduced in Java 8.
- A powerful abstraction for **asynchronous programming** and **task composition**.
- Unlike `Future`, it supports:
  - **Non-blocking chaining of tasks**
  - **Combining multiple async tasks**
  - **Exception handling**
  - **Callback-based execution**

---

### **CompletableFuture Basics**
```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task running in: " + Thread.currentThread().getName());
            return "Hello";
        });

        cf.thenApply(result -> result + " World")
          .thenAccept(System.out::println); // prints "Hello World"
          //The expression System.out::println replaces s -> System.out.println(s).
    }
}
```

**Key Points:**
- `supplyAsync()` runs a `Supplier` in a background thread using a default executor (common ForkJoinPool).
- `thenApply()` transforms data.
- `thenAccept()` consumes final result.

---

### **Chaining Multiple Tasks**
```java
CompletableFuture.supplyAsync(() -> "Data")
    .thenApply(data -> data.toUpperCase())
    .thenApply(data -> "Processed: " + data)
    .thenAccept(System.out::println);
```

---

### **Combining Tasks in Parallel**
```java
CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> "Task1 Result");
CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> "Task2 Result");

// Combine results when both complete
CompletableFuture<Void> combined = task1.thenCombine(task2, (t1, t2) -> t1 + " & " + t2)
                                        .thenAccept(System.out::println);
combined.join(); // wait for all to complete
```

---

### **Exception Handling**
```java
CompletableFuture.supplyAsync(() -> {
    throw new RuntimeException("Something went wrong");
})
.exceptionally(ex -> {
    System.out.println("Caught: " + ex.getMessage());
    return "Default Value";
})
.thenAccept(System.out::println);
```

---

### **Why Use CompletableFuture Instead of Executors?**
- Executors = manage thread pools, handle `Runnable`/`Callable`.
- CompletableFuture = manage async computation **flows**, chain tasks declaratively.
- Think: Executors = "engine", CompletableFuture = "workflow".

---

### **Practice Exercise**
**Goal:**  
- Fetch two datasets from APIs in parallel.
- Merge results with `thenCombine`.
- Handle possible exception by returning a default result.

**Hint:**
```java
CompletableFuture<String> api1 = CompletableFuture.supplyAsync(() -> "Data1");
CompletableFuture<String> api2 = CompletableFuture.supplyAsync(() -> "Data2");
```
Add an exception scenario to one API call.

---

## **Advanced Concurrency Tools**
These come from `java.util.concurrent` and are essential for synchronizing complex workflows.

---

### 1. **Semaphore**
- Limits concurrent access to a resource.
```java
import java.util.concurrent.Semaphore;

Semaphore semaphore = new Semaphore(3); // allow 3 permits

Runnable task = () -> {
    try {
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " acquired permit");
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    } finally {
        semaphore.release();
        System.out.println(Thread.currentThread().getName() + " released permit");
    }
};
```
**Use Case:** Restrict concurrent database connections.

---

### 2. **CountDownLatch**
- Wait until a set of tasks complete.
```java
import java.util.concurrent.CountDownLatch;

CountDownLatch latch = new CountDownLatch(3);

Runnable task = () -> {
    System.out.println(Thread.currentThread().getName() + " working");
    try { Thread.sleep(1000); } catch (InterruptedException e) {}
    latch.countDown();
};

for (int i = 0; i < 3; i++) new Thread(task).start();

try {
    latch.await(); // waits until count is 0
    System.out.println("All tasks finished");
} catch (InterruptedException e) {}
```
**Use Case:** Wait for all initialization tasks before starting main service.

---

### 3. **CyclicBarrier**
- All threads wait at a barrier until all have reached it.
```java
import java.util.concurrent.CyclicBarrier;

CyclicBarrier barrier = new CyclicBarrier(3, () -> {
    System.out.println("All threads reached barrier — proceeding...");
});

Runnable task = () -> {
    try {
        System.out.println(Thread.currentThread().getName() + " waiting");
        barrier.await();
    } catch (Exception e) {}
};
```
**Use Case:** Synchronize start of parallel tasks.

---

## **ThreadPoolExecutor (Custom)**
While `Executors.newFixedThreadPool()` etc. are convenience methods, the **ThreadPoolExecutor** class offers more control:
```java
ThreadPoolExecutor executor = new ThreadPoolExecutor(
    2, // core threads
    4, // max threads
    60, // idle time
    TimeUnit.SECONDS,
    new LinkedBlockingQueue<>(10) // task queue size
);
```
- You can monitor active threads, queue size, rejected tasks.

---

## **Best Practices Recap**
- **Graceful shutdown** always (`shutdown()`, `awaitTermination()`).
- Avoid **creating threads manually** — use pools.
- Exception handling: inside tasks or with `setUncaughtExceptionHandler`.
- Choose right pool based on workload pattern.
- Use advanced constructs for coordination instead of custom polling loops.

---

# **ForkJoinPool and Parallel Streams Deep Dive**

## **1. ForkJoinPool Overview**
### **What is ForkJoinPool?**
- A **specialized thread pool** introduced in Java 7.
- Designed for **divide-and-conquer tasks**.
- Splits a task into smaller subtasks (forks), processes them recursively, and combines (joins) the results.
- Uses **work-stealing**: idle threads "steal" tasks from other busy threads to maximize CPU utilization.

---

### **Key Features of ForkJoinPool**
- **Efficient parallelism**: Automatically balances workload across threads.
- **RecursiveTask**: For tasks that return a result.
- **RecursiveAction**: For tasks that don't return a result.
- **CommonPool**: A shared ForkJoinPool used by default.

---

### **ForkJoinPool Example: Sum of Array**
Let’s calculate the sum of an array by dividing the array into smaller chunks.

```java
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Long> {
    private long[] array;
    private int start, end;

    private static final int THRESHOLD = 10; // Split tasks if size > 10

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int size = end - start;
        if (size <= THRESHOLD) { // Base case: directly compute sum
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else { // Recursive case: split into subtasks
            int mid = start + size / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);
            leftTask.fork(); // Fork left task
            long rightResult = rightTask.compute(); // Compute right task
            long leftResult = leftTask.join(); // Join left task
            return leftResult + rightResult;
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        long[] array = new long[100];
        for (int i = 0; i < array.length; i++) array[i] = i + 1; // Fill array

        SumTask task = new SumTask(array, 0, array.length);
        long result = pool.invoke(task); // Submit task to pool
        System.out.println("Sum: " + result);
    }
}
```

### **Key Observations**
1. **Divide-and-conquer**: Task is split recursively until chunks are small enough.
2. **Work-stealing**: Threads dynamically pick tasks to maximize CPU usage.

---

### **ForkJoinPool API Highlights**
| Method          | Description                                              |
|------------------|----------------------------------------------------------|
| `invoke(task)`  | Submits a task and waits for result                       |
| `fork()`        | Submits a subtask for asynchronous execution              |
| `join()`        | Waits for the completion of a subtask                     |
| `compute()`     | Defines the task logic (recursive splitting or direct computation) |

---

### **Exercise: Practice ForkJoinPool**
**Goal:**  
- Create a ForkJoinPool program to find the maximum value in a large array.
- Split the array into smaller chunks recursively.
- Compare performance with a single-threaded approach.

---

## **2. Parallel Streams**
### **What are Parallel Streams?**
- Introduced in Java 8.
- A high-level abstraction for **parallel data processing**.
- Automatically uses the **ForkJoinPool** internally for parallel execution.
- Simplifies parallelism compared to manual ForkJoinPool implementation.

---

### **Key Features**
- Easy to use: Just call `.parallelStream()` on a collection.
- Automatically splits data into chunks and processes them in parallel.
- Great for **data-intensive operations** like filtering, mapping, and reducing.

---

### **Parallel Streams Example**
Let’s calculate the sum of numbers in a list using parallel streams.

```java
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().toList();

        // Sequential Stream
        long sequentialSum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sequential Sum: " + sequentialSum);

        // Parallel Stream
        long parallelSum = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("Parallel Sum: " + parallelSum);
    }
}
```

### **Key Observations**
- `.stream()` processes data sequentially.
- `.parallelStream()` splits data into chunks for parallel processing.
- Parallel streams internally use the **common ForkJoinPool**.

---

### **Parallel Streams vs ForkJoinPool**
| Feature           | Parallel Streams                  | ForkJoinPool                   |
|-------------------|-----------------------------------|--------------------------------|
| Abstraction       | High-level API                   | Low-level API                  |
| Use Case          | Simple data processing           | Complex recursive tasks        |
| Control           | Automatic                        | Manual task management         |

---

### **Exercise: Practice Parallel Streams**
**Goal:**  
- Use parallel streams to filter even numbers from a large list and calculate their sum.
- Measure time taken for sequential vs parallel execution.

---

## **ForkJoinPool vs Parallel Streams**
| Feature               | ForkJoinPool                     | Parallel Streams                |
|-----------------------|-----------------------------------|---------------------------------|
| **Complexity**        | Requires manual task splitting   | Fully automated                |
| **Use Case**          | Recursive tasks, tree structures | Bulk data processing           |
| **Performance**       | Fine-grained control             | Optimized for collections       |

---

## **Best Practices for ForkJoinPool and Parallel Streams**
### **ForkJoinPool**
1. Use **RecursiveTask** for computations with results.  
2. Avoid blocking operations (e.g., I/O) inside tasks — it reduces parallelism.  
3. Monitor pool size and thread usage for large datasets.

### **Parallel Streams**
1. Avoid using parallel streams for **small datasets** — overhead outweighs benefits.  
2. Be cautious with **shared mutable state** (e.g., modifying shared variables in parallel streams).  
3. Use `.forEachOrdered()` for ordered processing when necessary.

---

# **Deadlocks, Livelocks, and Synchronization Pitfalls**

## **1. What is a Deadlock?**
A **deadlock** is a situation where two or more threads are blocked forever, waiting for each other to release resources.

**Four conditions for deadlock (Coffman conditions)**:
1. **Mutual Exclusion** – Resource is held by only one thread at a time.
2. **Hold and Wait** – Thread holds one resource and waits for another.
3. **No Preemption** – Resources cannot be forcibly taken away.
4. **Circular Wait** – A cycle of threads exists, each waiting for a resource held by the next.

If all four are present — you can have a deadlock.

---

### **Deadlock Example**
```java
public class DeadlockExample {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("Thread 1: Holding LOCK1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for LOCK2...");
                synchronized (LOCK2) {
                    System.out.println("Thread 1: Acquired LOCK2!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println("Thread 2: Holding LOCK2...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for LOCK1...");
                synchronized (LOCK1) {
                    System.out.println("Thread 2: Acquired LOCK1!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

**What Happens?**
- **Thread 1** acquires `LOCK1` and waits for `LOCK2`.
- **Thread 2** acquires `LOCK2` and waits for `LOCK1`.
- Neither can proceed — **Deadlock**.

---

## **2. How to Prevent Deadlocks**
### **Prevention Strategies**
1. **Avoid Nested Locks** — Lock only one resource at a time.
2. **Lock Ordering** — Always acquire multiple locks in the same global order.
3. **Lock Timeout** — Use `tryLock(timeout)` from `ReentrantLock` to time out on lock acquisition.
4. **Use Higher-level concurrency utilities** — Avoid manual locking, use `ConcurrentHashMap`, `BlockingQueue`, etc.
5. **Reduce Lock Scope** — Lock only the smallest necessary block of code.

---

### **Example: Lock Timeout with ReentrantLock**
```java
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class SafeLockExample {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> safeLock(lock1, lock2));
        Thread t2 = new Thread(() -> safeLock(lock2, lock1));
        t1.start();
        t2.start();
    }

    static void safeLock(ReentrantLock first, ReentrantLock second) {
        try {
            if (first.tryLock(500, TimeUnit.MILLISECONDS)) {
                try {
                    Thread.sleep(100); // simulate work
                    if (second.tryLock(500, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " acquired both locks.");
                        } finally {
                            second.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " could not acquire second lock, avoiding deadlock.");
                    }
                } finally {
                    first.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```

---

## **3. Livelock**
- Similar to deadlock, but threads **keep changing state** in response to each other, and progress is never made.
- Example: Two people trying to pass in a hallway, both stepping aside repeatedly.

---

## **4. Starvation**
- A thread never gets CPU or resource time because others monopolize the resources.
- **Causes**: high-priority threads always running, or unfair locks.
- **Fix**: Use **fair locks** (`new ReentrantLock(true)`).

---

## **5. Synchronization Pitfalls**
### **a. Oversynchronization**
- Locking around code that doesn’t need it — hurts performance.
  
### **b. Double-checked Locking Issues** (before Java 5)
- Due to reordering in JVM, instance could appear initialized when it’s not.

**Correct way**:
```java
private static volatile Singleton instance;
public static Singleton getInstance() {
    if (instance == null) {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }
    return instance;
}
```

### **c. Shared Mutable State in Parallel Streams**
- Mutating external variables inside `.parallelStream()` causes race conditions.
  
**Bad:**
```java
List<Integer> list = new ArrayList<>();
IntStream.range(0, 1000).parallel().forEach(list::add); // NOT thread-safe
```

**Fix:** Use thread-safe collectors.
```java
List<Integer> safeList = IntStream.range(0, 1000)
    .parallel()
    .boxed()
    .collect(Collectors.toList());
```

---

## **6. Detecting Deadlocks**
- Use **jconsole** or **jvisualvm** (comes with JDK).
- Use `ThreadMXBean` in code:
```java
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

ThreadMXBean bean = ManagementFactory.getThreadMXBean();
long[] deadlockedThreads = bean.findDeadlockedThreads();
if (deadlockedThreads != null) {
    System.out.println("Deadlocked threads detected!");
}
```

---

## **7. Practice Exercise**
**Goal:**  
- Step 1: Write a program that intentionally creates a deadlock with two locks and two threads.
- Step 2: Solve the deadlock by:
  1. Enforcing lock ordering
  2. Using `tryLock` with timeout
- Step 3: Use `ThreadMXBean` to detect the deadlock.

---
# **Multithreaded Debugging Deep Dive**

Debugging multithreaded code is different from debugging sequential code because:
- Multiple threads can execute concurrently
- Bugs may appear **intermittent** or **non-reproducible**
- Race conditions can create **heisenbugs** (disappear when debugged!)

---

## **1. Understanding Thread Dumps**

A **thread dump** is a snapshot of all threads in the JVM and their states at a given moment.  
Generated using:
```bash
# On Linux/Mac
kill -3 <pid> 

# On Windows
CTRL + Break in console window running JVM

# Or with jcmd
jcmd <pid> Thread.print

# Or from code
Thread.getAllStackTraces()
```

---

### **Key Thread States in a Thread Dump**
| State                | Meaning                                                                 |
|----------------------|-------------------------------------------------------------------------|
| **RUNNABLE**         | Thread executing in CPU or waiting in OS queue                         |
| **BLOCKED**          | Waiting for a monitor lock                                              |
| **WAITING**          | Waiting indefinitely for another thread to notify                      |
| **TIMED_WAITING**    | Waiting with a timeout (e.g., `sleep`, join with timeout, `wait(timeout)`) |
| **TERMINATED**       | Thread has finished execution                                           |

---

### **Sample Deadlock in a Thread Dump**
```text
Found one Java-level deadlock:
=============================
"Thread-1":
  waiting to lock monitor 0x000000001c, object <LOCK2>, 
  which is held by "Thread-2"
"Thread-2":
  waiting to lock monitor 0x000000001a, object <LOCK1>,
  which is held by "Thread-1"
```

**Interpretation**:
- **Thread-1** holds `LOCK1` but wants `LOCK2`
- **Thread-2** holds `LOCK2` but wants `LOCK1`
- Circular dependency → deadlock

---

## **2. Detecting Deadlocks Programmatically**
We can detect deadlocked threads inside the JVM using `ThreadMXBean`:

```java
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {
    public static void main(String[] args) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads();
        if (threadIds != null) {
            ThreadInfo[] infos = bean.getThreadInfo(threadIds);
            for (ThreadInfo info : infos) {
                System.out.println("Deadlock detected: " + info.getThreadName());
            }
        } else {
            System.out.println("No deadlocks detected.");
        }
    }
}
```

---

## **3. Analyzing Contention**
**Symptoms of contention**:
- Threads stuck in `BLOCKED` state
- High CPU idle time but high thread count
- Threads frequently switching states

**Thread dump clue**:  
You’ll see many threads **WAITING to acquire the same monitor** — usually a sign that synchronization is too coarse-grained.

---

## **4. Tools for Multithreaded Debugging**
### **IDE Debuggers**
- IntelliJ IDEA / Eclipse let you **freeze a thread**, inspect variables, and step through code.

### **JConsole** (comes with JDK)
- Real-time CPU, memory, and thread monitoring
- Can trigger a thread dump from UI

### **VisualVM**
- Visualizes thread activity & deadlocks  
- Profiling memory and CPU

### **Java Mission Control & Flight Recorder**
- Low-overhead profiling for production systems  
- Allows analyzing exact thread contention percentages  
- Perfect for finding hotspots in concurrency

---

## **5. Strategy for Debugging Concurrency Issues**
1. **Reproduce under load** — often concurrency issues need high load to appear.
2. **Take multiple thread dumps** over intervals — deadlocks show up consistently in multiple dumps.
3. **Look for patterns** — if the same methods appear in waiting stacks, focus there.
4. **Reduce complexity** — temporarily simplify thread logic to isolate the issue.
5. **Log + Thread IDs** — always log with `Thread.currentThread().getName()` for tracing execution flow.

---

## **6. Example: Adding Thread Names**
```java
ExecutorService executor = Executors.newFixedThreadPool(3, r -> {
    Thread t = new Thread(r);
    t.setName("Worker-" + t.getId());
    return t;
});
```
You’ll see **Worker-1**, **Worker-2** in logs — much easier to trace.

---

## **7. Practice Debugging Scenario**
**Goal:**  
- Create a program that has an intentional deadlock (using 2 locks and 2 threads).
- Run it and generate a thread dump using `jcmd` or `jconsole`.
- Locate the deadlock in the dump and interpret it.
- Resolve the deadlock using **lock ordering** or `ReentrantLock.tryLock()`.

---
# **Java Concurrency – Performance Tuning & Best Practices**  
*(Final Step Before You’re “Production Ready”)*  

Now that you understand **thread creation**, **executors**, **async flows**, **synchronization**, **deadlocks**, and **debugging**, we need to focus on **making concurrent systems fast, efficient, and safe under real workloads**.  

---

## **1. Thread Pool Sizing**
The number of threads in a pool has **direct impact** on throughput and CPU utilization.

### **General Formula**
For **CPU-bound tasks**:
```text
Optimal threads ≈ Number of CPU cores + 1
```

For **I/O-bound tasks**:
```text
Optimal threads ≈ Number of CPU cores * (1 + WaitTime / ComputeTime)
```
(Essentially: more threads to compensate for blocking on I/O)

**Example:**
- If a task spends 80% waiting (I/O) and 20% computing:
```java
cores = Runtime.getRuntime().availableProcessors();
threads = cores * (1 + 0.8/0.2) = cores * 5
```

---

## **2. Avoid Oversubscription**
- **Too many threads** → Context switching overhead & cache thrashing.
- **Too few threads** → CPU underutilization.

Use `Runtime.getRuntime().availableProcessors()` to adapt to environment.

---

## **3. Reduce Contention**
**Problem**: Multiple threads fight over the same lock/resource.

### **Solutions:**
1. **Minimize lock scope**:
```java
synchronized(this) {
    // Only what must be locked
}
```
2. **Use concurrent data structures**:  
   - `ConcurrentHashMap` instead of `HashMap`  
   - `ConcurrentLinkedQueue` instead of `LinkedList`
3. **Reduce shared mutable state** → more thread-local storage, immutable objects.

---

## **4. Avoid Blocking in Parallel Code**
In `ForkJoinPool` or `.parallelStream()`:
- Avoid `Thread.sleep()`, database calls, or heavy I/O inside parallel sections.
- Use non-blocking I/O or async processing if possible.

---

## **5. Avoid False Sharing**
**False sharing**: Multiple threads update variables that live in the **same CPU cache line**, leading to unnecessary cache invalidation.

### **Example**:
```java
// Bad: Threads updating these will share cache lines
volatile long counter1;
volatile long counter2;
```

**Solution**: Use `@Contended` (Java 8+) or pad variables to occupy different cache lines.

---

## **6. Limit Synchronization in Hot Paths**
If a frequently executed method is heavily synchronized, it becomes a bottleneck.

**Better**: Use lock-free or optimistic concurrency techniques:  
- `AtomicInteger`, `AtomicLong` for counters  
- `StampedLock` for read-mostly data

---

## **7. Thread Affinity & Priority**
- Thread priority tuning rarely helps performance — scheduler differences make it unreliable.
- Avoid starvation by not keeping many high-priority threads.

---

## **8. Use Batching**
Processing in batches reduces synchronization cost:
```java
List<Task> batch = queue.poll(10, TimeUnit.MILLISECONDS);
processBatch(batch);
```

---

## **9. Monitor Thread Pools in Production**
Even the best-designed concurrent systems degrade over time if queues build up.

### Metrics to Track:
- Active thread count
- Task queue size
- Task wait time
- Rejected task count

**With ThreadPoolExecutor:**
```java
ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
System.out.println("Active Threads: " + exec.getActiveCount());
System.out.println("Queue Size: " + exec.getQueue().size());
```

---

## **10. Use the Right Tool**
- **Independent tasks** → FixedThreadPool  
- **Short-lived bursts** → CachedThreadPool  
- **Recursive computation** → ForkJoinPool  
- **Data processing** → Parallel Streams (when thread-safety is OK)  
- **Scheduling** → ScheduledThreadPool (`Executors.newScheduledThreadPool()`)

---

## **11. Graceful Shutdown**
Always shutdown executors to free resources:
```java
executor.shutdown();
if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
    executor.shutdownNow();
}
```

---

## **12. Test Under Load**
Concurrency issues often appear **only under stress**:
- Use load testing frameworks (Gatling, JMeter).
- Simulate workloads matching production patterns.

---

## **13. Checklist for Production-Ready Concurrency**
✅ Correct thread pool sizing based on workload  
✅ No obvious deadlocks in testing  
✅ Minimized lock contention and hot-spot synchronization  
✅ Thread names set for logging and debugging  
✅ Proper shutdown hooks registered  
✅ Monitoring + alerting for backlog growth  
✅ Tested at >100% expected load  

---

### **Performance Tuning Exercise**
1. Build a simulation of a web server handling 100,000 requests:
    - Version A: Creates a new thread per request  
    - Version B: Uses a fixed thread pool  
2. Measure:
    - Response time under load  
    - CPU usage & memory  
3. Tune the thread pool until optimal throughput is achieved.

---