package geekbrain;

public class Main {


        private final Object monitor = new Object();
        private volatile char letter = 'A';
        public static void main(String[] args) {
            Main waiter = new Main();
            Thread threadA = new Thread(() -> {
                waiter.printA();
            });
            Thread threadB = new Thread(() -> {
                waiter.printB();
            });
            Thread threadC = new Thread(() -> {
                waiter.printC();
            });
            threadA.start();
            threadB.start();
            threadC.start();

        }

        public void printA() {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'A') {
                        monitor.wait();}
                        System.out.print("A");
                        letter = 'B';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        public void printB() {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'B') {
                            monitor.wait();}
                        System.out.print("B");
                        letter = 'C';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        public void printC() {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'C') {
                            monitor.wait();}
                        System.out.print("C");
                        letter = 'A';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

