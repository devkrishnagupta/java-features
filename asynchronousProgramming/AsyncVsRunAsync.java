package asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncVsRunAsync {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CompletableFuture.supplyAsync(() -> {
            // Asynchronous operation to download a file
            System.out.println("downloading file using:- "+"supply async");
            System.out.println("I am in supplyAsync - "+Thread.currentThread().getName());
            delay(1);
            return "Testing";
        }).thenAcceptAsync((file) -> {
            // Further operations with the downloaded file
            System.out.println("I am in thenAcceptAsync - "+Thread.currentThread().getName());
            System.out.println("processFile -> "+file);
            delay(1);
        });

        CompletableFuture.runAsync(()->{
            System.out.println("I am in runAsync - "+Thread.currentThread().getName());
            System.out.println("downloading file using:- "+"run async");
            delay(1);
        }).thenRunAsync(()->{
            System.out.println("I am in thenRunAsync - "+Thread.currentThread().getName());
            System.out.println("processFile -> ");
            delay(1);
        });

        delay(5);
        System.out.println("Main thread completed:- "+Thread.currentThread().getName());
    }

    public static void delay(int time){
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
