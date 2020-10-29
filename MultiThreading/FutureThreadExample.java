import java.util.concurrent.*;
class FutureThreadExample {
    public static void main(String[] args) throws Exception {
 ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable Callable=()->{
            Thread.sleep(2000);
            return "Hello World";
        };
        Future future = executorService.submit(Callable);

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(500);
        }

        System.out.println("Task completed! Retrieving the result");
        System.out.println(future.get());

        executorService.shutdown();
    }
}