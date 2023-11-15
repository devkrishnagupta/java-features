package functionalProgrammingInJava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitAndSkip {
    public static void main(String[] args) {
            List<Integer> numbers = Stream.iterate(1, n -> n + 1)
                                     .limit(20) // Create a stream of integers from 1 to 20
                                     .collect(Collectors.toList());

        int pageSize = 5; // Number of elements per page
        int pageNumber = 2; // Page number (1-based index)

        List<Integer> page = numbers.stream()
                                   .skip((pageNumber - 1) * pageSize) // Skip elements from previous pages
                                   .limit(pageSize) // Limit the result to the current page size
                                   .collect(Collectors.toList());

        System.out.println("Page " + pageNumber + ": " + page);
    }
}
