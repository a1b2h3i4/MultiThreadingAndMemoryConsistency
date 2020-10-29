import java.util.*;
import java.util.Arrays;
import java.util.concurrent.*;
class InvokeAnyExample {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(2);
        Callable callable1=()->{
            return "Hello thread1";
        };
        Callable callable2=()->{
            return "Hello thread2";
        };
        Callable callable3=()->{
            return "Hello thread3";
        };
        List<Callable<String>> callableList=Arrays.asList(callable1,callable2,callable3);
        String response=scheduledExecutorService.invokeAny(callableList);
        System.out.println(response);

        scheduledExecutorService.shutdown();
    }
}