
import java.util.concurrent.Semaphore;

public class Dock {

    private String type;
    int generalCapacity = 0;
    Semaphore dsmp;

    final int loadingPerSecond = 100;
    int unloadedCargo = 0;

    public Dock(String type, int generalCapacity, Semaphore dsmp) {
        this.type = type;
        this.generalCapacity = generalCapacity;
        this.dsmp = dsmp;
    }


    public String getType() {
        return type;
    }

    public synchronized void load (Ship ship) {

        try {
            dsmp.acquire();
            System.out.println("Корабль типа " + ship.getType() + " начал грузиться...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        while (!ship.isShipFull() && generalCapacity > 0) {
            try {
                Thread.sleep(1000);
                ship.setCurrentCapacity(ship.getCurrentCapacity() + loadingPerSecond);
                generalCapacity = generalCapacity- loadingPerSecond;
                System.out.println("В корабле типа " + ship.getType() + " - " + ship.getCurrentCapacity() + " ед. груза");
                System.out.println("В порту типа " + this.getType() + " осталось " + this.generalCapacity + " ед. груза" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            dsmp.release();

            if (this.generalCapacity == 0) {
                System.out.println();
                System.out.println("ПОРТ ТИПА \'" + this.getType() + "\' ПОЛНОСТЬЮ РАЗГРУЖЕН!");
                System.out.println();
            }
        }

}



