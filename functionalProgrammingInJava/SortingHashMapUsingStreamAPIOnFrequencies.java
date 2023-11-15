package functionalProgrammingInJava;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingHashMapUsingStreamAPIOnFrequencies {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<String> strings = Arrays.asList("alpha", "beta", "gamma", "beta");
        Map<String, Integer> map = strings
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(),
                                String::length, (i1, i2) -> i1,
                                LinkedHashMap::new))
                .entrySet()
                .stream()
                // .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                // .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> (e1+e2)/2,
                        LinkedHashMap::new));

        System.out.println(map);
        // output: {alpha=5, gamma=5, beta=4}
    }
}