package geekbrain;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CountDownLatch count1;
    private CountDownLatch count2;
    private CountDownLatch count3;
    private Semaphore tunnel;
    private Semaphore win;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }



    public Car(Race race, int speed, CountDownLatch count1, CountDownLatch count2, CountDownLatch count3, Semaphore tunnel, Semaphore win) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
        this.tunnel = tunnel;
        this.win = win;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
count1.countDown();
count2.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        count3.countDown();
        try {
            win.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Победил " + this.name);
    }
}
