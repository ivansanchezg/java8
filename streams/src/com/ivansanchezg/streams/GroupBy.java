package com.ivansanchezg.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ivansanchezg.models.Item;

public class GroupBy {

    private List<String> fruits;
    private List<Item> items;

    public GroupBy() {
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

        items = new ArrayList<>();
        items.add(new Item("paper", 10, 0.99f));
        items.add(new Item("pen", 13, 0.49f));
        items.add(new Item("stapler", 6, 2.25f));
        items.add(new Item("pencil", 32, 0.49f));
        items.add(new Item("paper", 20, 0.99f));
        items.add(new Item("pen", 7, 0.49f));
        items.add(new Item("stapler", 3, 2.25f));
        items.add(new Item("pen", 5, 0.49f));
    }

    public Map<String, Long> countFruits() {
        return fruits.stream()
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));
    }

    public Map<String, Integer> groupItemsByName() {
        return items.stream()
            .collect(Collectors.groupingBy(
                Item::getName, Collectors.summingInt(Item::getQuantity)
            ));
    }

    public Map<Float, List<Item>> groupItemsByPrice() {
        return items.stream()
            .collect(Collectors.groupingBy(Item::getPrice));
    }

    public Map<Float, Set<String>> groupItemNamesByPrice() {
        return items.stream()
            .collect(Collectors.groupingBy(
                Item::getPrice,
                Collectors.mapping(Item::getName, Collectors.toSet())
            ));
    }

    public void runExamples() {
        Map<String, Long> countFruits = countFruits();
        System.out.println(countFruits);

        Map<String, Integer> countItems = groupItemsByName();
        System.out.println(countItems);

        Map<Float, List<Item>> itemsByPrice = groupItemsByPrice();
        System.out.println(itemsByPrice);

        Map<Float, Set<String>> namesByPrice = groupItemNamesByPrice();
        System.out.println(namesByPrice);

        System.out.println("----------------------------");
    }
}
