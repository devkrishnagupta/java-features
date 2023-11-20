package collectionsFrameworks;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

        taskQueue.offer(() -> {
            System.out.println("Running first task in the queue");
        });

        taskQueue.offer(() -> {
            System.out.println("Running Second task in the queue");
        });

        // taskQueue.offer(null); // this will return NullPointerException as we can't add null values in ConcurrentLinkedQueue.
        
        System.out.println("Queue Size :-> "+taskQueue.size());

        Runnable task1 = taskQueue.poll();
        task1.run();

        Runnable task2 = taskQueue.poll();
        task2.run();
        // System.out.println(taskQueue.poll());// this will not throw Exception, It will return just null if Queue is empty.
        System.out.println("Queue Size :-> "+taskQueue.size());
    }
}
