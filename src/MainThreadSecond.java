import java.util.ArrayList;
import java.util.List;

public class MainThreadSecond {

    static final List<Integer> list1 = new ArrayList<>();
    static final List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 1; i++) {
                synchronized (list1) {
                    add1();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (list2) {
                        add2();
                        System.out.println("Я тут");
                    }
                }
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 1; i++) {
                synchronized (list2) {
                    add1();
                    synchronized (list1) {
                        add2();
                        System.out.println("Я тут");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
        System.out.println();

        //Вычисления в несколько потоков
    }

    public static void add1() {
        list1.add(1);
    }

    public static void add2() {
        list2.add(2);
    }
}
