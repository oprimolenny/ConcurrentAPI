import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarrierAction());

        Thread thread1 = new Thread(new MyThread(barrier, "tr_1"));
        Thread thread2 = new Thread(new MyThread(barrier, "tr_2"));
        Thread thread3 = new Thread(new MyThread(barrier, "tr_3"));

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("the end of programm");
        if (barrier.getNumberWaiting() != 0) {
            System.out.println("Придется ломать");
            barrier.reset();
        }
    }
}
