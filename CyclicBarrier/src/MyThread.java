import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

    CyclicBarrier barrier;
    String name;

    public MyThread(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Поток " + name + " запущен");
        try {
            System.out.println("Поток " + name + " встал перед барьером");
            barrier.await();
            System.out.println("Поток " + name + " проник за барьер");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
