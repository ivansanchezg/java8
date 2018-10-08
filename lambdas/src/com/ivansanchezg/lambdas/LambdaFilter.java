package com.ivansanchezg.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.ivansanchezg.models.Person;

public class LambdaFilter {

    private List<Integer> numbers;
    private List<String> languages;
    private Map<String, String> phoneDirectory;
    
    public LambdaFilter() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        languages = Arrays.asList("Spanish", null, "French", "English", null, "Japanese");

        phoneDirectory = new HashMap<>();
        phoneDirectory.put("Ivan", "12345678");
        phoneDirectory.put("Stuart", "33124323");
        phoneDirectory.put("Jean", "66533212");
    }

    public List<Integer> filter() {
        return numbers.stream()
            .filter(number -> number % 2 == 0)
            .collect(Collectors.toList());
    }

    public List<String> filterNulls() {
        return languages.stream()
            .filter(language -> language != null)
            .collect(Collectors.toList());
    }

    public Integer findAnyDivisible(int divider) {
        // This returns any value that is divisible by the "divider"
        // If no match is found a null is returned
        return numbers.stream()
            .filter(number -> number % divider == 0)
            .findAny()
            .orElse(null);
    }

    public Map<String, String> filterMap() {
        return phoneDirectory.entrySet()
            .stream()
            .filter(map -> map.getValue().startsWith("6"))
            .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
            // .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // Alternative
    }

    public void runExamples() {
        System.out.println("LambdaFilter\n");

        List<Integer> filteredNumbers = this.filter();
        filteredNumbers.forEach(System.out::println);

        System.out.println("----------------------");

        List<String> filteredLanguages = this.filterNulls();
        System.out.println(filteredLanguages);

        System.out.println("----------------------");
        
        Integer find7 = this.findAnyDivisible(7);
        System.out.println(find7);

        System.out.println("----------------------");
        
        Integer find11 = this.findAnyDivisible(11);
        System.out.println(find11);

        System.out.println("----------------------");

        Map<String, String> filteredMap = this.filterMap();
        System.out.println(filteredMap);
    }
}
