import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultipleCallableThreads {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Play by changin pool length
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result of Task1"+Thread.currentThread().getName();
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2"+Thread.currentThread().getName();
        };

        Callable<String> task3 = () -> {
            Thread.sleep(5000);
            return "Result of Task3"+Thread.currentThread().getName();
        };

        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);

        List<Future<String>> futures = executorService.invokeAll(taskList);

        for(Future<String> future: futures) {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            System.out.println(future.get());
        }

        executorService.shutdown();
        
    }
}