package geekbrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        CountDownLatch count1 = new CountDownLatch(CARS_COUNT);
        CountDownLatch count2 = new CountDownLatch(1);
        CountDownLatch count3 = new CountDownLatch(CARS_COUNT);
        Semaphore tunnel = new Semaphore(CARS_COUNT/2);
        Semaphore win = new Semaphore(1);

        new Thread(() -> {
            try {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
                //Thread.sleep(2000);

                Race race = new Race(new Road(60), new Tunnel(), new Road(40));
                Car[] cars = new Car[CARS_COUNT];

                for (int i = 0; i < cars.length; i++) {
                    cars[i] = new Car(race, 20 + (int) (Math.random() * 10), count1, count2, count3, tunnel, win);
                }
                //cb.await();
                for (int i = 0; i < cars.length; i++) {
                    new Thread(cars[i]).start();
                }
                count1.await();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                count2.countDown();
                count3.await();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                System.exit(0);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

}

