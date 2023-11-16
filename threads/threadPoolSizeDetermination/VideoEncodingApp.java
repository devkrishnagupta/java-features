package threads.threadPoolSizeDetermination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoEncodingApp {

    public static void main(String[] args) {
        int availableCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors:- " + availableCores);
        int numberOfThreads = Math.max(availableCores - 1, 1); // Adjust as needed
        System.out.println("Number of thread pool size:- " + numberOfThreads);
        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);

        // Submit video encoding tasks to the thread pool.
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                encodeVideo(1); // Simulated video encoding task
            });
        }

        threadPool.shutdown();
    }

    private static void encodeVideo(final int i) {
        // Simulate video encoding (CPU-bound) task.
        // Complex calculations and compression algorithms here.
        try{
            Thread.sleep(1000);
            System.out.println("Completed => "+i);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
