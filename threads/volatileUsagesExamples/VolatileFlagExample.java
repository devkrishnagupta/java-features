package threads.volatileUsagesExamples;

import java.util.concurrent.TimeUnit;

public class VolatileFlagExample {

    private static volatile boolean flag = false;

    static Thread readerThread = new Thread(() -> {
        while (!flag) {
            System.out.println("Currently waiting for Flag to become true!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Reader thread: Flag is now true");
    });

    static Thread writeThread = new Thread(() -> {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
        System.out.println("Writer Thread: Flag is set to true.");
    });

    public static void main(String[] args) {
        readerThread.start();
        writeThread.start();
    }
}
