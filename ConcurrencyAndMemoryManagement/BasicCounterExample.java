import java.util.concurrent.*;
class Counter {
    int count = 0;

    // add synchronized and non synchronized method
    public void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}   
class BasicCounterExample { 
    public static void main(String[] args)  throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Counter counter = new Counter();

        for(int i = 0; i < 1000; i++) {
            executorService.submit(() -> counter.increment());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
    
        System.out.println("Final count is : " + counter.getCount());  
    }
}