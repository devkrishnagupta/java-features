package functionalProgrammingInJava;

import java.util.Arrays;
import java.util.List;

public class UsagesOfSumFunctionInStreamApi {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);

        Integer ans1 = list1.stream()
                        .filter(n->n%2==0)
                        .mapToInt(n->n)
                        .sum();

        Integer ans2 = list1.stream()
                .filter(n->n%2==0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even numbers:- ");
        System.out.println("Using Method 1 => "+ans1);
        System.out.println("Using Method 2 => "+ans2);
    }
}
