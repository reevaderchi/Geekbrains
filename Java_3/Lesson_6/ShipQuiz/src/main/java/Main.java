import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) {

        final int SHIPS_QUANTITY = 12;
        final int DOCS_QUANTITY = 3;
        final int SHIPS_IN_DOCK_CAPACITY = 1;
        final int SHIPS_IN_CHANNEL_CAPACITY = 2;

        CyclicBarrier cb = new CyclicBarrier(SHIPS_QUANTITY);

        Semaphore dsmp1 = new Semaphore(SHIPS_IN_DOCK_CAPACITY);
        Semaphore dsmp2 = new Semaphore(SHIPS_IN_DOCK_CAPACITY);
        Semaphore dsmp3 = new Semaphore(SHIPS_IN_DOCK_CAPACITY);

        Semaphore csmp = new Semaphore(SHIPS_IN_CHANNEL_CAPACITY, true);

        Channel channel = new Channel(csmp);

        Dock[] docks = new Dock[DOCS_QUANTITY];

        for (int i = 0; i < DOCS_QUANTITY; i++) {

            docks[0] = new Dock("одежда", 2700, dsmp1);
            docks[1] = new Dock("еда", 5900, dsmp2);
            docks[2] = new Dock("топливо", 8500, dsmp3);

        }

        Ship[] ships = new Ship[SHIPS_QUANTITY];

        for (int i = 0; i < SHIPS_QUANTITY; i++) {
            ships[0] = new Ship("одежда", docks[0], cb, channel);
            ships[1] = new Ship("одежда_2", docks[0], cb, channel);
            ships[2] = new Ship("еда", docks[1], cb, channel);
            ships[3] = new Ship("еда_2", docks[1], cb, channel);
            ships[4] = new Ship("топливо", docks[2], cb, channel);
            ships[5] = new Ship("топливо_2", docks[2], cb, channel);
            ships[6] = new Ship("топливо_5", docks[2], cb, channel);
            ships[7] = new Ship("топливо_6", docks[2], cb, channel);
            ships[8] = new Ship("еда_3", docks[1], cb, channel);
            ships[9] = new Ship("еда_4", docks[1], cb, channel);
            ships[10] = new Ship("топливо_3", docks[2], cb, channel);
            ships[11] = new Ship("топливо_4", docks[2], cb, channel);
        }

        for (int i = 0; i < SHIPS_QUANTITY; i++) {
            new Thread(ships[i]).start();
        }

    }

}
