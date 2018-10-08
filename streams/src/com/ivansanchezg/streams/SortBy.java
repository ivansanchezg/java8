package com.ivansanchezg.streams;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortBy {
    
    List<String> fruits;

    public SortBy() {
        fruits = Arrays.asList(
            "apple",
            "pear",
            "banana",
            "orange",
            "banana",
            "apple",
            "apple",
            "pear"
        );
    }

    public Map<String, Long> countAndSortAscFruits() {
        Map<String, Long> countedFruits = fruits.stream()
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));

        Map<String, Long> result = new LinkedHashMap<>();

        countedFruits.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue())
            .forEachOrdered(fruitCount -> result.put(fruitCount.getKey(), fruitCount.getValue()));

        return result;
    }

    public Map<String, Long> countAndSortDescFruits() {
        Map<String, Long> countedFruits = fruits.stream()
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));

        Map<String, Long> result = new LinkedHashMap<>();

        countedFruits.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEachOrdered(fruitCount -> result.put(fruitCount.getKey(), fruitCount.getValue()));

        return result;
    }

    public void runExamples() {
        Map<String, Long> countFruitsAsc = countAndSortAscFruits();
        System.out.println(countFruitsAsc);

        Map<String, Long> countFruitsDesc = countAndSortDescFruits();
        System.out.println(countFruitsDesc);
    }
}
