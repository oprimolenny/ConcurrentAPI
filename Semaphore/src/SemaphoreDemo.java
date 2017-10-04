import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        DecThread decThread = new DecThread("Decreasing", sem);
        IncThread incThread = new IncThread("Increasing", sem);

        Thread thread1 = new Thread(decThread);
        Thread thread2 = new Thread(incThread);

        thread1.start();
        thread2.start();


    }
}
