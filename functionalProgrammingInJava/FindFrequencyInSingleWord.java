package functionalProgrammingInJava;

import java.util.stream.Collectors;
//Functions of the streams API:- count + min + max + sum + average + filter + map + distinct + collect + flatMap + mapToInt + summaryStatistics(return IntSummaryStatistics)
public class FindFrequencyInSingleWord {
        public static void main(String[] args) {
        System.out.println("Hello, World!");
        String list = "abcdabaf";
        String ans=findDuplicates1(list);
        System.out.println(ans);
    }
    
    public static String findDuplicates1(String str){
        String strWithReq = str.chars()
        .mapToObj(n->(char)n)
        .collect(Collectors.groupingBy(n->n, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry->entry.getValue()>1)
        .map(entry -> ""+entry.getKey()+""+entry.getValue())
        .collect(Collectors.joining());
        return strWithReq;
    }
}
