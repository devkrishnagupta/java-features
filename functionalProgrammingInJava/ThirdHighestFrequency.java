package functionalProgrammingInJava;

import java.util.*;
import java.util.stream.Collectors;

public class ThirdHighestFrequency {
    public static int findThirdHighestFrequencyInList(List<Integer> list) {
        int result = list.stream()
            .collect(Collectors.groupingBy(n->n, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
            .skip(2)
            .findFirst()
            .map( entry -> entry.getKey())
            .orElse(-1);
            return result;
    }
    public static int findThirdHighestFrequencyInArray(int[] arr) {
        int result = Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort in descending order by count
        .skip(2) // Skip the first two most frequent elements
        .findFirst()
        .map(Map.Entry::getKey)
        .orElse(-1);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,2,1,1,3,4,5};
        int result1 = findThirdHighestFrequencyInArray(arr);
        System.out.println("In array " + result1);
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int result2 = findThirdHighestFrequencyInList(list);
        System.out.println("In list " + result2);
    }
}