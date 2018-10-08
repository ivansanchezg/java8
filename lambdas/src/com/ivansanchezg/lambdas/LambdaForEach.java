package com.ivansanchezg.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.ivansanchezg.models.Person;

public class LambdaForEach {

    private List<Integer> list;
    private List<Person> people;
    private Map<String, String> phoneDirectory;
    
    public LambdaForEach() {
        list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        people = new ArrayList<>();
        people.add(new Person("Ivan", "Sanchez", 27));
        people.add(new Person("John", "Doe", 33));
        people.add(new Person("Mary", "Jane", 18));

        phoneDirectory = new HashMap<>();
        phoneDirectory.put("Ivan", "12345678");
        phoneDirectory.put("Stuart", "33124323");
        phoneDirectory.put("Jean", "66533212");
    }

    public void forEach() {
        list.forEach(number -> System.out.println(number));
    }

    public void forEachObject() {
        people.forEach(person -> System.out.println(person.getLastName()));
    }

    public void forEachMap() {
        phoneDirectory.forEach((key, value) -> System.out.println(value + " is " + key + "'s phone"));
    }

    public void runExamples() {
        System.out.println("LambdaForEach\n");

        this.forEach();

        System.out.println("----------------------");

        this.forEachMap();

        System.out.println("----------------------");

        this.forEachObject();
    }
}
