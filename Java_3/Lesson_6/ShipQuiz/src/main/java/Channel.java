import java.util.concurrent.Semaphore;

public class Channel {

    Semaphore csmp;

    public Channel (Semaphore csmp) {
        this.csmp = csmp;
    }

    public void passChannel(Ship ship) {

            try {
                System.out.println("Корабль типа " + ship.getType() + " готовится к прохождению пролива...");
                this.csmp.acquire();
                System.out.println("Корабль типа " + ship.getType() + " проходит пролив...");
                Thread.sleep(200 + (int)(Math.random() * 50));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Корабль типа " + ship.getType() + " успешно переплыл через пролив");
                this.csmp.release();
            }
    }

}
