import java.util.concurrent.CyclicBarrier;

public class Ship implements Runnable{

    private CyclicBarrier cb;

    private int currentCapacity = 0;

    Dock dock;
    Channel channel;

    private String type;
    final int generalCapacity = 500;

    public Ship(String type, Dock dock, CyclicBarrier cb, Channel channel) {
        this.type = type;
        this.dock = dock;
        this.cb = cb;
        this.channel = channel;
    }

    public String getType() {
        return type;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public boolean isShipFull() {
        if (getCurrentCapacity() >= generalCapacity) {
            System.out.println("Корабль типа " + this.getType() + " максимально загружен! Погрузка в порту завершена!");
            return true;
        }
        return false;
    }

    public void run() {

        try {
            System.out.println("Корабль типа " + this.getType() + " готовится к отплытию");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println("Корабль типа " + this.getType() + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (this.dock.generalCapacity > 0) {

            channel.passChannel(this);
            System.out.println("Корабль типа " + this.getType() + " ожидает погрузки...");
            dock.load(this);
            channel.passChannel(this);
            this.unload();
        }

    }

    public synchronized void unload() {

        this.dock.unloadedCargo += this.currentCapacity;
        setCurrentCapacity(0);
        System.out.println("Корабль типа " + this.getType() + " разгрузился!");
        System.out.println("КОЛИЧЕСТВО ПЕРЕВЕЗЕННОГО ГРУЗА \'" + dock.getType() + "\' = " + this.dock.unloadedCargo);
    }



}

