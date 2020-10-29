import java.util.concurrent.*;
class CallableThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable callable=new Callable<String>(){
            @Override
            public String call() throws Exception{
                Thread.sleep(100);
                return "dzfhsok";
            }
        };
        Future<String> futureList=executorService.submit(callable);
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        String result = futureList.get();
        System.out.println(result);

        executorService.shutdown();
    }
}