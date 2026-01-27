package Synchronization;

class Counter{
    
    // Shared variable
    private int c = 0; 

    // Synchronized method to increment counter
    public synchronized void inc(){
        c++; 
        
    }

    // Synchronized method to get counter value
    public synchronized int get(){
        return c; 
        
    }
}

class CriticalNum{
    private int num=0;

    public void inc(){
        synchronized (this) {num++;}
    }
    public int get() { return num; }
}

class Table{
    
    synchronized static void printTable(int n){
        
        for (int i = 1; i <=3; i++){
            
            System.out.println(n * i);
            try {
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Thread1 extends Thread{
    
    public void run() {
        Table.printTable(1);
    }
}

class Thread2 extends Thread {
    public void run() {
        Table.printTable(10);
    }
}

class Volatility{
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void start() {
        new Thread(() -> {
            while (running) {
                System.out.println("Running...");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Stopped.");
        }).start();
    }
}
public class LearnSynchronization {
    public static void main(String[] args) {
        // Shared resource
        Counter cnt = new Counter(); 

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                cnt.inc();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                cnt.inc();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + cnt.get());

        CriticalNum cn=new CriticalNum();
        Thread t3=new Thread(()-> {
            for(int i=0;i<100;i++){
                cn.inc();
            }
        });

        Thread t4=new Thread(()-> {
            for(int i=0;i<100;i++){
                cn.inc();
            }
        });

        t3.start();
        t4.start();

        try{
            t3.join();
            t4.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("After Updation the Critical Code is : "+ cn.get());

        Thread1 t5 = new Thread1();
        Thread2 t6 = new Thread2();
        t5.start();
        t6.start();
        //Both threads t1 and t2 call the static synchronized method printTable(). The lock is applied to the Table.class object, ensuring that only one thread can access the method at a time, even if no object instance is shared.

        Volatility v1=new Volatility();
        v1.start();

        try{
            Thread.sleep(600);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        v1.stop();
        //The volatile variable running ensures that updates made by one thread (in stop()) are visible to the thread running the loop in start().
    }
}
