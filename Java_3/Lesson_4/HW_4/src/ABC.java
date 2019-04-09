public class ABC {

    private volatile char currentLetter = 'A';

    public static void main(String[] args) {

        ABC abc = new ABC();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                abc.printA();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                abc.printB();
            }
        });


        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                abc.printC();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void printA() {

            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        wait();
                    }
                    System.out.println("A");
                    currentLetter = 'B';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                        e.printStackTrace();
            }
    }

    public synchronized void printB() {

            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        wait();
                    }
                    System.out.println("B");
                    currentLetter = 'C';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public synchronized void printC() {

            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        wait();
                    }
                    System.out.println("C");
                    currentLetter = 'A';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

}
