package Synchronization;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LearnCompletableFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // A more complex, non-blocking asynchronous pipeline
        CompletableFuture<Void> pipeline = CompletableFuture
            // 1. Asynchronously fetch a user ID. Returns CompletableFuture<Integer>
            .supplyAsync(() -> {
                System.out.println("Fetching User ID... Thread: " + Thread.currentThread().getName());
                // Simulate network call
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {}
                // Uncomment to test exception handling
                // if (true) throw new RuntimeException("User Service Unavailable!");
                return 12345;
            }, executor)

            // 2. Use thenCompose for a DEPENDENT async call.
            // Input is the user ID (Integer), output is another CompletableFuture<String>.
            .thenComposeAsync(userId -> {
                System.out.println("Fetching User Name for ID " + userId + "... Thread: " + Thread.currentThread().getName());
                // This is also an async operation (e.g., another microservice call)
                return CompletableFuture.supplyAsync(() -> {
                    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {}
                    return "Rahul Batra";
                }, executor);
            }, executor)
            
            // 3. Use thenApply for a SYNCHRONOUS transformation.
            // Input is user name (String), output is a formatted greeting (String).
            .thenApply(userName -> {
                System.out.println("Formatting greeting for " + userName + ". Thread: " + Thread.currentThread().getName());
                return "Hello, " + userName;
            })

            // 4. Use thenAccept to perform a final action (a "terminal operation").
            // Input is the greeting (String), this is the end of the line.
            .thenAccept(greeting -> {
                System.out.println("Final Result: " + greeting);
            })

            // 5. Handle any exception that occurred anywhere in the pipeline.
            .exceptionally(ex -> {
                System.err.println("An error occurred: " + ex.getMessage());
                return null; // Must return a value of the same type (Void)
            });

        System.out.println("Pipeline has been set up. Main thread is free.");

        // In a real server, the thread would return to the pool.
        // In this demo, we wait for the pipeline to finish to see the output.
        pipeline.join(); // Blocks the main thread until the pipeline is complete.

        executor.shutdown();
    }
}
