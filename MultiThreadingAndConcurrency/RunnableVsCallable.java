import java.util.concurrent.*;

class FactorialCallable implements Callable<Integer> {
    private int number;

    public FactorialCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}

class FactorialRunnable implements Runnable {
    private int number;

    public FactorialRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("Factorial of Via Runnable " + number + " is: " + result);
    }
}

public class RunnableVsCallable {
    public static void main(String[] args) {
        // Using Runnable
        Thread runnableThread = new Thread(new FactorialRunnable(5));
        
        // Using Callable
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futureResult = executorService.submit(new FactorialCallable(5));
        try {
            runnableThread.start();
            System.out.println("Factorial of 5 is: " + futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
