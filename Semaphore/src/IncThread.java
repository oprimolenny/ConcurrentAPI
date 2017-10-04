import java.util.concurrent.Semaphore;

public class IncThread implements Runnable {

    String name;
    Semaphore semaphore;

    public IncThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Поток " + name + " получил разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + " : " +Shared.count);

                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Поток " + name + " освобождает разрешение");
        semaphore.release();

    }


}
