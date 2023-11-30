package optimalPerformanceExamples.sumOfEvenNumbersFromList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class UsingCustomCollectorWithParaallelStreamRandomeSizeList {
    public static void main(String[] args) {
        Random random = new Random();
        int listSize = random.nextInt(10)+1; // Random size between 1 to 10
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<listSize;i++){
            numbers.add(random.nextInt(100)); // Random numbers between 0 to 99
        }
        System.out.println("Generated list: "+numbers);
        
        int sum = numbers.parallelStream()
                        .filter(n->n%2==0) //Filter even numbers
                        .collect(new EvenNumberSumCollector()); // Use custom collector

        System.out.println("Sum of even numbers: "+sum);
    }
}

class EvenNumberSumCollector implements Collector<Integer, int[], Integer>{
    @Override
    public Supplier<int[]> supplier() {
        System.out.println("supplier");
        return () -> new int[]{0};
    }
    @Override
    public BiConsumer<int[], Integer> accumulator() {
        System.out.println("accumulator");
        return (acc, num) -> {
            if (num%2==0) {
                acc[0]+=num;
            }
        };
    }
    @Override
    public BinaryOperator<int[]> combiner() {
        System.out.println("combiner");
        return (left, right) -> {
            left[0] += right[0];
            return left;
        };
    }
    @Override
    public Function<int[], Integer> finisher() {
        System.out.println("finisher");
        return acc -> acc[0];
    }
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics");
        return Collections.singleton(Characteristics.CONCURRENT);
    }
}