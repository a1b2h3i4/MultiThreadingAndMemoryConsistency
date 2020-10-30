import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
class ReentrantLockMethodsCounter {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public int incrementAndGet() {
        // Check if the lock is currently acquired by any thread
        System.out.println("IsLocked : " + lock.isLocked());

        // Check if the lock is acquired by the current thread itself.
        System.out.println("IsHeldByCurrentThread : " + lock.isHeldByCurrentThread());

        // Try to acquire the lock
        boolean isAcquired =Boolean.FALSE;
        try{
        isAcquired = lock.tryLock(1000,TimeUnit.SECONDS);
        }
        catch(Exception ex){}
        System.out.println("Lock Acquired : " + isAcquired + "\n");

        if(isAcquired) {
            try {
                Thread.sleep(2000);
                count = count + 1;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                lock.unlock();
            }
        }
        return count;
    }
}
public class ReentrantLockExample{
public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter();

    executorService.submit(() -> {
       System.out.println("IncrementCount (First Thread) : " +
               lockMethodsCounter.incrementAndGet() + "\n");
    });

    executorService.submit(() -> {
        System.out.println("IncrementCount (Second Thread) : " +
                lockMethodsCounter.incrementAndGet() + "\n");
    });

    executorService.shutdown();
}
}