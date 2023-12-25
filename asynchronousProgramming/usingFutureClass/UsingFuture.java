package asynchronousProgramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class UsingFuture {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> callable = () -> {
            System.out.println("callable called");
            delay(1);
            return "Hello from Futue";
        };
        Future<String> future = executorService.submit(callable);
        System.out.println("Do something else");
        String message = "Empty";
        try {
            System.out.println("Is Task completed Before Get: "+future.isDone());
            message = future.get();//so Future.get is blocking the thread
            System.out.println("Is Task completed After Get: "+future.isDone());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Message is: "+message);
        executorService.shutdown();
    }

    private static void delay(int time){
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}