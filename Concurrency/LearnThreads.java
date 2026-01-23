package Concurrency;

public class LearnThreads {
    public static void main(String[] args) throws InterruptedException{
        Thread myThread=new Thread(new Runnable() {
            @Override 
            public void run(){
                //code that will run
                System.out.println("We are now in thread: "+Thread.currentThread().getName());
                System.out.println("The Priority for our Thread : "+Thread.currentThread().getPriority());
            }
        });

        //to run thread call via start method
        myThread.setName("New Worker Thread");
        myThread.setPriority(9);
        System.out.println("We are in thread: "+Thread.currentThread().getName()+" befre start");
myThread.start();
        System.out.println("We are in thread: "+Thread.currentThread().getName()+" after completition");

        System.out.println("Thread Going for a Sleep");
        
        try{
            myThread.sleep(10000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Thread after sleep");
    }
}
