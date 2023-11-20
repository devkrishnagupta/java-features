package asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallbackExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1);
            System.out.println("I am in completableFuture - "+Thread.currentThread().getName());
            return "Tech recipes";
        }, executorService).thenApply(s->{
            return "Hello  from thenApply - "+Thread.currentThread().getName();
        }).thenAccept(s -> {
            System.out.println("Result set is - "+Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println("Inside run method - "+Thread.currentThread().getName());
        });
        System.out.println("I am in main thread - "+Thread.currentThread().getName());
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
