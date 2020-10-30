import java.util.concurrent.*;
import java.util.concurrent.locks.*;
class ReadWriteThreadCounter{
    ReadWriteLock lock = new ReentrantReadWriteLock();

    private int count = 0;

    public int incrementAndGetCount() {
        lock.writeLock().lock();
        try {
            count = count + 1;
            return count;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getCount() {
        lock.readLock().lock();
        try {
            return count;
        } finally {
            lock.readLock().unlock();
        }
    }
}
public class ReadWriteThreadExample {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ReadWriteThreadCounter atomicCounter = new ReadWriteThreadCounter();

        for(int i = 0; i < 1000; i++) {
            executorService.submit(() -> atomicCounter.incrementAndGetCount());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final Count is : " + atomicCounter.getCount());
    }
}