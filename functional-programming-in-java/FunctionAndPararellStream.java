package functionalProgrammingInJava;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionAndPararellStream {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Integer> list = Arrays.asList(1,2,3,4,1,2,3,4);
        List<Integer> twoiceList = list
        .parallelStream()
        .map(twoiceTheElementInTheList)
        .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(twoiceList);
    }

    public static Function<Integer, Integer> twoiceTheElementInTheList = (e) -> {
        return e*2;
    };
}
