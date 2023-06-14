import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            int count = 0;

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000);
                    count++;
                }
            }
            catch (InterruptedException e) {
                System.out.println("Ты думал целых " + count + "секунд");
            }

        };

        Thread thread1 = new Thread(runnable1);

        thread1.start();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько будет 2 x 2 = ");
        int answer = scanner.nextInt();

        if (answer == 4) {
            thread1.interrupt();
        }


    }
}