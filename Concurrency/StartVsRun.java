package Concurrency;

class MyThread extends Thread {

    public void run(){

        System.out.println("Thread running using start()");
    }
}
class MyThread1 extends Thread{
    
    public void run(){
        
        System.out.println("Thread running using run()");
    }
}


public class StartVsRun {
    public static void main(String[] args)
    {
        MyThread t1 = new MyThread();
        
        // Starts a new thread
        t1.start(); 
        MyThread1 t2 = new MyThread1();
        
        // Does NOT start a new thread
        //Here, run() is executed in the main thread, so no multithreading occurs.
        t2.run(); 
        t2.run();
    }
}

//we can't call the start() method twice otherwise it will throw an IllegalStateException 
// whereas run() method can be called multiple times as it is just a normal method calling.
