package com.ivansanchezg.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.ivansanchezg.models.Person;

public class LambdaMap {

    private List<Integer> numbers;
    private List<Person> people;
    
    public LambdaMap() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        people = new ArrayList<>();
        people.add(new Person("Ivan", "Sanchez", 27));
        people.add(new Person("John", "Doe", 33));
        people.add(new Person("Mary", "Jane", 18));
    }

    public List<Integer> multiplyByN(int n) {
        return numbers.stream()
            .map(number -> number * n)
            .collect(Collectors.toList());
    }

    public List<String> mapFirstNames() {
        return people.stream()
            .map(Person::getFirstName) // shorcut to map(person -> person.getFirstName())
            .collect(Collectors.toList());
    }

    public List<String> getLastNamesUpperCase() {
        return people.stream()
            .map(person -> person.getLastName().toUpperCase())
            .collect(Collectors.toList());
    }

    public void runExamples() {
        System.out.println("LambdaMap\n");

        List<String> firstNames = this.mapFirstNames();
        firstNames.forEach(name -> System.out.println(name));

        System.out.println("----------------------");

        List<String> lastNamesUpperCase = this.getLastNamesUpperCase();
        System.out.println(lastNamesUpperCase);
    }
}
