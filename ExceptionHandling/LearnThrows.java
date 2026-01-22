public class LearnThrows {
    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(10000);
        System.out.println("Hello Geeks");

        try {
            fun();
        }
        catch (IllegalAccessException e) {
            System.out.println("Caught in main.");
        }
    }

    static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }

}

//It is only used for checked exceptions. Unchecked exceptions do not require throws
