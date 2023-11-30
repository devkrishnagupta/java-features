package optimalPerformanceExamples.sumOfEvenNumbersFromList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class UsingCountDownLatchRandomSizeList {
    private static volatile int totalSum = 0;
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int listSize = random.nextInt(10)+1; // Randome size between 1 to 10
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<listSize;i++){
            numbers.add(random.nextInt(100)); // Random numbers between 0 to 99
        }
        System.out.println("Generated list: "+numbers);
        int threadCount = 4;
        int chunkSize = listSize/threadCount;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for(int i=0;i<threadCount;i++){
            int start = i*chunkSize;
            int end = (i==threadCount-1) ? listSize : (i+1)*chunkSize;
            List<Integer> subList = numbers.subList(start, end);
            Thread thread = new Thread(()->{
                int localSum = calculateSumOfEvens(subList);
                totalSum+=localSum;
                latch.countDown();
            });
            thread.start();
        }
        latch.await();
        System.out.println("Sum of even numbers: "+totalSum);
    }

    private static int calculateSumOfEvens(List<Integer> subList) {
        int sum=0;
        for(int val: subList){
            if (val%2==0) {
                sum+=val;
            }
        }
        return sum;
    }
}
