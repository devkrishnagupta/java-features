package collectionsFrameworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapOptimizedWay {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        
        String country = "india";
        map.put("india1", new ArrayList<>(Arrays.asList("done")));
        map.put(country, map.getOrDefault(country, new ArrayList<String>()));
        map.get(country).add("Bihar");
        
        //second method
        map.computeIfAbsent(country, countryKey -> new ArrayList<String>()).add("Test");/////////////////////return value from hashMap at particular key if value is present 
        // and if not present then it will perform computations and return value at that key and here countryKey key in HashMap
        System.out.println(map.computeIfAbsent("country1", k-> new ArrayList<String>()).add("okay"));
        map.putIfAbsent("country1", new ArrayList<>());/////////////////////////////////////////// it will return null if key not present previously. And if the key is present then it will return value at that key
        //And put item in HashMap only if key is not present.
        System.out.println(map);
    }
}
