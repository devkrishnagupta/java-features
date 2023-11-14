package functionalProgrammingInJava;
import java.util.*;
import java.util.stream.Collectors;

public class FindingFequenciesFromListOfStrings {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //  program to print duplicate values using java 8
        List<String> list = Arrays.asList("dev", "test", "dev", "OK", "OK", "OK");
        
        Map<String,Long> ans = list
        .stream()
        .collect(Collectors.groupingBy(n->n, Collectors.counting()));
        
        Map<String,Long> duplicatesMap = ans
        .entrySet()
        .stream()
        .filter(x->x.getValue()>1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        List<Map.Entry<String, Long>> entriesList = new ArrayList<>(duplicatesMap.entrySet());
        
        //Collections.sort(entriesList, (a, b) -> a.getValue().compareTo(b.getValue()));
        //Collections.sort(entriesList, Comparator.comparing(Map.Entry::getValue));
        //Collections.sort(entriesList, Comparator.comparingLong(Map.Entry::getValue));
        Collections.sort(entriesList, Map.Entry.comparingByValue());
        
        System.out.println(ans);
        System.out.println();
        System.out.println(duplicatesMap);
        System.out.println();
        System.out.println(entriesList);
    }
}
