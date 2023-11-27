package functionalProgrammingInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordMappingToIntegersInString {
    public static void main(String[] args) {
        String inputStr = "1,Dev,2,Ajay,Mohit,Ram,3,abc,2,monu,4,Test";
        // Map<Integer, List<String>> resultMap = parseString1(inputStr);
        // Map<Integer, List<String>> resultMap = parseString2(inputStr);
        Map<Integer, List<String>> resultMap = parseString3(inputStr);
        for(Map.Entry<Integer, List<String>> entry: resultMap.entrySet()){
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }
    }

    private static Map<Integer, List<String>> parseString3(String inputStr) {
        Map<Integer, List<String>> resultMap = new LinkedHashMap<>();
        List<String> elements = Arrays.asList(inputStr.split(","));
        
        // IntStream.range(0, elements.size()/2)
        // .forEach(i -> {
        //     int key = Integer.parseInt(elements.get(i*2));
        //     String value = elements.get(i+2+1);
        //     resultMap.computeIfAbsent(key, k ->  new ArrayList<>()).add(value);
        // });
        // return resultMap;

        // List<Integer> keys = elements.stream()
        //         .filter(s -> s.matches("\\d+"))
        //         .map(Integer::parseInt)
        //         .collect(Collectors.toList());

        // List<String> values = elements.stream()
        //         .filter(s -> !s.matches("\\d+"))
        //         .collect(Collectors.toList());

        // IntStream.range(0, keys.size())
        //         .forEach(i -> {
        //             int key = keys.get(i);
        //             String value = values.get(i);
        //             resultMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        //         });
        return resultMap;
    }

    private static Map<Integer, List<String>> parseString2(String inputStr) {
        Map<Integer, List<String>> resultMap = new LinkedHashMap<>();
        String[] elements = inputStr.split(",");
        
        Integer key = null;
        for(String element: elements){
            try{
                key = Integer.parseInt(element);
                resultMap.putIfAbsent(key, new ArrayList<>());
            }catch(NumberFormatException ignored){
                if (key!=null) {
                    resultMap.get(key).add(element);
                }
            }
        }
        return resultMap;
    }

    private static Map<Integer, List<String>> parseString1(String inputStr) {
        String[] arr = inputStr.split(",");
        Map<Integer, List<String>> ans = new HashMap<>();
        Integer key = null;
        for(String str : arr){
            boolean addInList = true;
            if (str.length() == 1 && str.charAt(0) > 47 && str.charAt(0) < 58) {
                key = Integer.valueOf(str);
                addInList=false;
            }
            if (key != null && !ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            if (key != null && addInList) {
                ans.get(key).add(str);
            }
        }
        return ans;
    }
}
