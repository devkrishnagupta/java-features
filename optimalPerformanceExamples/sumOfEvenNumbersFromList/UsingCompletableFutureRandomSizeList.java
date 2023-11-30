package optimalPerformanceExamples.sumOfEvenNumbersFromList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UsingCompletableFutureRandomSizeList{
    public static void main(String[] args) {
        Random random = new Random();
        int listSize = random.nextInt(10)+1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<listSize;i++){
            numbers.add(random.nextInt(100));
        }
        System.out.println("Generated list: "+numbers);
        int threadCount = 4;//Number of thread
        int chunkSize = listSize/threadCount;
        CompletableFuture<Integer>[] completableFutures = new CompletableFuture[threadCount];
        for(int i=0;i<threadCount;i++){
            int start = i*chunkSize;
            int end = (i==threadCount-1) ? listSize : (i+1)*chunkSize;
            List<Integer> subList = numbers.subList(start, end);
            completableFutures[i]=CompletableFuture.supplyAsync(()->calculateSumOfEvens(subList));
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures);
        System.out.println(allFutures.isDone());
        try{
            allFutures.get();
            System.out.println(allFutures.isDone());
            int totalSum = 0;
            for(CompletableFuture<Integer> future: completableFutures){
                totalSum += future.get();
                System.out.println("Current sum: "+totalSum);
            }
            System.out.println("Sum of even numbers: "+totalSum);
        }catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        // System.out.println(Arrays.toString(completableFutures));
    }

    private static int calculateSumOfEvens(List<Integer> subList){
        int sum=0;
        for(int val: subList){
            if(val%2==0)
                sum+=val;
        }
        return sum;
    }
}