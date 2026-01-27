package Synchronization;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Worker that keeps taking tasks from queue and running them
class Worker extends Thread {
    private BlockingQueue<Runnable> taskQueue;
    private volatile boolean isRunning = true;

    public Worker(BlockingQueue<Runnable> queue, String name) {
        super(name);
        this.taskQueue = queue;
    }

    public void run() {
        try {
            while (isRunning) {
                Runnable task = taskQueue.take();
                if (task == SimpleThreadPool.POISON_PILL) {
                    // Exit loop when poison pill received
                    break;
                }
                task.run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        isRunning = false;
        this.interrupt(); // in case it's blocked on take()
    }
}

// Simple Thread Pool
class SimpleThreadPool {
    private BlockingQueue<Runnable> taskQueue;
    private Worker[] workers;
    static final Runnable POISON_PILL = () -> { };

    public SimpleThreadPool(int poolSize) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[poolSize];

        // Create and start workers
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker(taskQueue, "Worker-" + (i + 1));
            workers[i].start();
        }
    }

    // Submit new task to queue
    public void submit(Runnable task) {
        taskQueue.offer(task);
    }

    // Gracefully shutdown
    public void shutdown() {
        // Send one poison pill per worker
        for (int i = 0; i < workers.length; i++) {
            taskQueue.offer(POISON_PILL);
        }
    }
}

public class ExampleThreadPool {
    public static void main(String[] args) {
        // Initialize thread pool with 3 workers
        SimpleThreadPool pool = new SimpleThreadPool(3);

        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown after tasks are submitted
        pool.shutdown();
    }
}
