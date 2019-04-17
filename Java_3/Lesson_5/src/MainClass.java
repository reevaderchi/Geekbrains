import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(0);

        Semaphore smp = new Semaphore(CARS_COUNT / 2, true);
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT, new BarAction());
        CyclicBarrier finishBarrier = new CyclicBarrier(CARS_COUNT + 1);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(ai, cb, finishBarrier, race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
                      new Thread(cars[i]).start();
        }

        try {
            finishBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}