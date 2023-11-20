package asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsyncExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); 
        Supplier<String> supplier = () -> {
            delay(1);
            System.out.println("I am in supplier - "+Thread.currentThread().getName());
            return "Hello from supplier";
        };
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executorService);
        System.out.println("I am in main - "+Thread.currentThread().getName());
        String value = completableFuture.join();
        System.out.println("Value is:- "+value);
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
