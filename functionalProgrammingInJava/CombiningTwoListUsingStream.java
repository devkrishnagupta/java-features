package functionalProgrammingInJava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombiningTwoListUsingStream {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8,9,10);
        List<Integer> ans = Stream.concat(list2.stream(), list1.stream())
                            // .sorted(Comparator.comparingInt(n->n))
                            // .sorted((n1, n2)->n1-n2 > 0 ? 1 : -1)
                            .sorted((n1, n2)->Integer.compare(n1, n2))
                            .collect(Collectors.toList());
        System.out.println(ans);
    }
}
