package functionalProgrammingInJava;

import java.util.List;
import java.util.stream.Collectors;

public class FindingCharactersInString {
    public static void main(String[] args) {
        String str = "H e l l        o123,";
        List<Character> ans1 = str.chars()
                            .mapToObj(ch -> (char)ch)
                            .filter(
                                ch->Character.valueOf(Character.toUpperCase(ch)) >= 65 &&
                                Character.valueOf(Character.toUpperCase(ch)) <= 90
                            )
                            .collect(Collectors.toList());

        List<Character> ans2 = str.chars()
                            .mapToObj(ch -> (char)ch)
                            .filter(
                                ch->Character.valueOf(Character.toUpperCase(ch)) >= 65 &&
                                Character.valueOf(Character.toUpperCase(ch)) <= 90
                            )
                            .collect(Collectors.toList());

        System.out.println("Answers1 => "+ans1);
        System.out.println("Answers2 => "+ans2);
    }
}
