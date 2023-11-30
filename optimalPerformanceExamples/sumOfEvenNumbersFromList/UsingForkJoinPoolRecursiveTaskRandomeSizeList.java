package optimalPerformanceExamples.sumOfEvenNumbersFromList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class UsingForkJoinPoolRecursiveTaskRandomeSizeList {

    public static void main(String[] args) {
        Random random = new Random();
        int listSize = random.nextInt(20) + 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Generated List: " + list);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        int sum = forkJoinPool.invoke(new EvenTaskNumber(list));

        System.out.println("Sum of even numbers:- " + sum);
    }
}

class EvenTaskNumber extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 5; // Threshold to process sublist subsequently.
    private final List<Integer> list;

    EvenTaskNumber(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        int size = list.size();
        if (size <= THRESHOLD) {
            return sequentialSum();
        }
        int midPoint = size / 2;

        List<Integer> leftSubList = list.subList(0, midPoint);
        List<Integer> rightSubList = list.subList(midPoint, size);

        EvenTaskNumber leftTask = new EvenTaskNumber(leftSubList);
        EvenTaskNumber rightTask = new EvenTaskNumber(rightSubList);

        invokeAll(leftTask, rightTask);

        return leftTask.join() + rightTask.join();
    }

    private int sequentialSum() {
        int sum = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
}