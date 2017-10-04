import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        Thread thread = new Thread(new MyThread(cdl));

        thread.start();

        try {
            System.out.println("Before cdl.await()");
            cdl.await();
            System.out.println("After cdl.await()");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Завершение потока исполнения");
    }
}
