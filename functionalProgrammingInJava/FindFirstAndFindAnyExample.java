package functionalProgrammingInJava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Functions of the streams API:- count + min + max + sum + average + filter + map + distinct + collect + flatMap + mapToInt + summaryStatistics(return IntSummaryStatistics)

public class FindFirstAndFindAnyExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 6, 7, 8, 9, 10);
    
        Optional<Integer> findFirst = list.stream().findFirst();
        Optional<Integer> finndAny = list.parallelStream().findAny();

        System.out.println("Find First without Optional => " + (findFirst.isPresent() ? findFirst.get() : "Not Presnt!"));
        System.out.println("Find Any without Optinal => " + (finndAny.isPresent() ? finndAny.get() : "Not Present!"));

        int findFirstWithDefault = list.stream().findFirst().orElse(-1);
        int findAnyWithoutDeafult = list.parallelStream().findAny().orElse(-1);

        System.out.println("Find First without Optional => " + findFirstWithDefault);
        System.out.println("Find Any without Optinal => " + findAnyWithoutDeafult);
    }
}
