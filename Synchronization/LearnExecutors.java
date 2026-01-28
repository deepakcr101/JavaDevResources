package Synchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*; 

//Its core principle is to separate the submission of a task from the mechanics of how that task will be run. 

public class LearnExecutors {
     public static void main(String[] args) throws ExecutionException, 
InterruptedException { 
        // 1. Create an ExecutorService with a fixed pool of 2 threads. 
        // In Ciena's world, this could represent parallel processing of two network data streams. 
        System.out.println("Creating ExecutorService with 2 threads..."); 
        ExecutorService executor = Executors.newFixedThreadPool(2); 
 
        // 2. Define a task that returns a value (Callable). 
        // This could simulate a task like fetching a device's configuration, which takes time. 
        Callable<String> fetchConfigTask = () -> { 
            System.out.println("Executing task in thread: " + 
Thread.currentThread().getName()); 
            TimeUnit.SECONDS.sleep(3); // Simulate network latency 
            return "Device_Config_Data_v1.2.3"; 
        }; 
 
        // 3. Submit the task to the ExecutorService. 
        // This returns a Future immediately. The main thread does not block here. 
        System.out.println("Submitting the task..."); 
        Future<String> futureResult = executor.submit(fetchConfigTask); 
 
        // ... The main thread can do other work here while the task runs in the background ... 
        System.out.println("Main thread is doing other work..."); 
        TimeUnit.SECONDS.sleep(1); 
 
        // 4. Get the result from the Future. 
        // The get() method BLOCKS until the result is available. 
        System.out.println("Waiting for the result from the Future..."); 
        String config = futureResult.get(); // This line will block for about 2 more seconds. 
         
        System.out.println("Result received: " + config); 
 
        // 5. Always shut down the executor. 
        // This will wait for running tasks to finish but won't accept new ones. 
        System.out.println("Shutting down the executor..."); 
        executor.shutdown(); 
    } 
}
