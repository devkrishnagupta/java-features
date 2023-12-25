package functionalProgrammingInJava;

import java.util.*;

public class StringParsingWithStream {
    public static void main(String[] args) {
        String input = "1,Dev,2,Ajay,Mohit,Ram,3,abc,2,monu,4,Test";

        Map<Integer, List<String>> resultMap = parseStringUsingStream(input);

        // Displaying the output
        resultMap.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    public static Map<Integer, List<String>> parseStringUsingStream(String input) {
        List<String> elements = Arrays.asList(input.split(","));
        Map<Integer, List<String>> resultMap = new HashMap<>();
        Integer key = null;
        for(String element: elements){
            try{
                key = Integer.parseInt(element);
            }catch(NumberFormatException e){
                resultMap.computeIfAbsent(key, newKey -> new ArrayList<>()).add(element);
            }
        }
        return resultMap;
    }
}
