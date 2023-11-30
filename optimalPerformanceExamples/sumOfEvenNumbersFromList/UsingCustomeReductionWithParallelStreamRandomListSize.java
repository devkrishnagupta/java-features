package optimalPerformanceExamples.sumOfEvenNumbersFromList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UsingCustomeReductionWithParallelStreamRandomListSize {
    public static void main(String[] args) {
        Random random = new Random();
        int listSize = random.nextInt(10)+1; // Random size between 1 to 10
        List<Integer> numbers = new ArrayList<>();
        // Fill the list with random elements
        for(int i=0;i<listSize;i++){
            numbers.add(random.nextInt(100)); // Random numbers between 0 99
        }
        System.out.println("Generated list: " + numbers);
        
        AtomicInteger sum = numbers.parallelStream()
                                    .collect(
                                        () -> new AtomicInteger(0),
                                        UsingCustomeReductionWithParallelStreamRandomListSize::accumulate,
                                        UsingCustomeReductionWithParallelStreamRandomListSize::combine
                                    );
        
        System.out.println("Sum of even numbers: "+sum);
    }

    private static void accumulate(AtomicInteger  sum, Integer num){
        if (num%2==0) {
            sum.getAndAdd(num);
        }
    }

    private static void combine(AtomicInteger left, AtomicInteger right){
        left.getAndAdd(right.get());
    }
}