package Concurrency;

class CookingTask extends Thread {
    private String task;

    CookingTask(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(task + " is being prepared by " +
            Thread.currentThread().getName());
    }
}

class CookingJob implements Runnable {
    private String task;

    CookingJob(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(task + " is being prepared by " +
            Thread.currentThread().getName());
    }
}


// Thread class implementation
class ThreadImpl extends Thread{
    
    @Override
    public void run(){
        
        // Output: Thread Class Running
        System.out.println("Thread Class Running");
    }
}

// Runnable interface implementation
class RunnableThread implements Runnable{
    
    @Override
    public void run(){
        
        // Output: Runnable Thread Running
        System.out.println("Runnable Thread Running");
    }
}


public class LearnThreads {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new CookingTask("Pasta");
        Thread t2 = new CookingTask("Salad");
        Thread t3 = new CookingTask("Dessert");
        Thread t4 = new CookingTask("Rice");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread t5 = new Thread(new CookingJob("Soup"));
        Thread t6 = new Thread(new CookingJob("Pizza"));
        Thread t7 = new Thread(new CookingJob("Burger"));

        t5.start();
        t6.start();
        t7.start();

        ThreadImpl t10 = new ThreadImpl();
        t10.start();

        // Create and start Runnable interface thread
        RunnableThread r = new RunnableThread();
        Thread t12 = new Thread(r);
        t12.start();

        // Wait for both threads to complete
        try {
            t10.join(); // Wait for t1
            t12.join(); // Wait for t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/*
 A Thread is a program that starts with a method() frequently used in this class only known as the start() method. This method looks out for the run() method which is also a method of this class and begins executing the body of the run() method. 
*/
