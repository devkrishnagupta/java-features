package optimalPerformanceExamples.sumOfEvenNumbersFromList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsingParallelStreamRandomSizeList {
    public static void main(String[] args) {
        Random random = new Random();
        int listSize = random.nextInt(10)+1;
        List<Integer> list = new ArrayList<>();
        //Fill the list with random elements
        for(int i=0;i<listSize;i++){
            list.add(random.nextInt(100));
        }
        
        System.out.println("Generated list: "+list);
        
        int sum = list.parallelStream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();

        System.out.println("Sum of even numbers: "+sum);
    }
}
