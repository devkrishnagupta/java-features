import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            delay(1);
            System.out.println("I am in runnable - "+Thread.currentThread().getName());
        };
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, executorService);
        System.out.println("I am in main thread - "+Thread.currentThread());
        completableFuture.join();
        executorService.shutdown();
    }

    public static void delay(int time){
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}