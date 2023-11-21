package optimalPerformanceExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SumOfEvenNumbersInRandomSizeList {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        AtomicInteger sum = new AtomicInteger();
        ArrayList<Integer> list = new ArrayList<>();
        int listSize = 10;//getRandomNumber();
        for(int i=0;i<listSize;i++){
            list.add(getRandomNumber());
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int threadCount = 4;//availableProcessors;
        System.out.println("Available Processors: "+availableProcessors);
        System.out.println("List: "+list);
        System.out.println("List Size: "+listSize);

        int chunkSize = listSize/threadCount;
        System.out.println("Chunk Size: "+chunkSize +" Thread Count: "+threadCount);
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<threadCount;i++){
            int start = i*chunkSize;
            int end = (i==threadCount-1) ? listSize : (i+1)*chunkSize;
            List<Integer> subList = list.subList(start, end);
            System.out.println(" start "+start+" end "+end+" subList: "+subList);
            executor.execute(() -> {
                int localSum = subList.parallelStream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
                int tempResult = sum.addAndGet(localSum);
                System.out.println(" Local Sum: "+localSum+" tempResult: "+tempResult);
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            //Waiting for executor to complete it's tasks
        }
        System.out.println("Final sum of even numbers: "+sum);        
    }

    public static int getRandomNumber(){
        int max=20,min=10;
        Random random = new Random();
        return random.nextInt(max-min+1)+min;
    }
}
