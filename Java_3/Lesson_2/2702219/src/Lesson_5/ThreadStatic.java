package Lesson_5;

public class ThreadStatic {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test.test();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test.test();
            }
        }).start();
    }

}

class Test {
    static synchronized void test() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
