public class TwoThreads {

    static int a = 0;
    static int b = 0;

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                a++;
            }
            synchronized (lock2) {
                b++;
            }

        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                b++;
            }
            synchronized (lock1) {
                a++;
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println(a);
        System.out.println(b);
    }


    //задание курьера - "выдано курьеру"
    //Курьер доставил
    //Человек оплатил

    //ЗК - с "выдано курьеру" на "выполнено",
    //ЗК - проставить булеан-переменную "оплачено"

    //*Первым прилетает событие на оплату
    //*Оно находит ЗК в таблице со статусом "выдано курьеру"
    //**прилетает событие о доставке и сразу же записывает в базу "выполнено"
    //*Записываем изменения по оплате, мы перезаписываем статус "выполнено" обратно в "выдано курьеру"

//
//
    //16 потоков = 100
    //100 / 16 = 6...


//
    ////состояние гонки


    //a = 0


    //чтение                    0
    //сложение (а + 1)          -           -
    //запись результата         1           1


    //первый прочитал (в а сейчас 0)
    //первый сложил ( в а сейчас 0)
    //вторая прочитал (в а сейчас 0)
    //второй сложил (в а сейчас 0)
    //второй записал (в а сейчас 1)
    //первый записал (1 перезапишется на 1)

    //long start = System.currentTimeMillis();
//
    //Thread thread1 = new Thread(() -> {
    //    long a = 0;
    //    for (int i = 0; i < Integer.MAX_VALUE - 4; i += 4) {
    //        a += i;
    //    }
    //    System.out.println(a);
    //});
//
    //Thread thread2 = new Thread(() -> {
    //    long a = 0;
    //    for (int i = 1; i < Integer.MAX_VALUE - 4; i += 4) {
    //        a += i;
    //    }
    //    System.out.println(a);
    //});
//
    //Thread thread3 = new Thread(() -> {
    //    long a = 0;
    //    for (int i = 2; i < Integer.MAX_VALUE - 4; i += 4) {
    //        a += i;
    //    }
    //    System.out.println(a);
    //});
//
    //Thread thread4 = new Thread(() -> {
    //    long a = 0;
    //    for (int i = 3; i < Integer.MAX_VALUE; i += 4) {
    //        a += i;
    //    }
    //    System.out.println(a);
    //});
//
    //thread1.start();
    //thread2.start();
    //thread3.start();
    //thread4.start();
//
    //thread1.join();
    //thread2.join();
    //thread3.join();
    //thread4.join();
//
    //long finish = System.currentTimeMillis();
    //System.out.println(finish - start);


    //}
}
