package functionalProgrammingInJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class FindingDuplicatesFromList {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,1,2,3,4);
        Set<Integer> ans=findDulicates2(list);
        System.out.println(ans);
    }
    public static Set<Integer> findDulicates1(List<Integer> list){
        Set<Integer> items = new HashSet<>();
        Predicate<Integer> notPresentInSet = n -> !items.add(n);
        Set<Integer> unique = list.stream().filter(notPresentInSet).collect(Collectors.toSet());
        return unique;
    }
    public static Set<Integer> findDulicates2(List<Integer> list){
        Set<Integer> unique = list
        .stream()
        .collect(Collectors.groupingBy(n->n, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue()>1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());
        return unique;
    }
    public static Set<Integer> findDuplicates3(List<Integer> list){
        return list
        .stream()
        .filter(n->Collections.frequency(list, n)>1)
        .collect(Collectors.toSet());
    }
}