package asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombiningTwoAsynchronousResults {
    public static void main(String[] args) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside the future1");
            return fetchDataFromMicroservicesService("Service 1");
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside the future2");
            return fetchDataFromMicroservicesService("Service 2");
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future1, future2);

        completableFuture.thenRun(()->{
            try {
                String result1 = future1.get();
                String result2 = future2.get();
                System.out.println("Combined Results: " + result1 + " and " + result2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program completed");
    }

    public static String fetchDataFromMicroservicesService(String serviceName){
        //Simulating fetching data from a web service
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serviceName + " --> data";
    }
}
