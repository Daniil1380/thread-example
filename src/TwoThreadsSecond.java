import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreadsSecond {

    static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {


        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_000_000; i++) {
                a.getAndSet(10000);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100_000_000; i++) {
                int b = a.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(a);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
