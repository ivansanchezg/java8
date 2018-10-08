package com.ivansanchezg.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.ivansanchezg.models.Person;

public class LambdaReduce {

    private List<Integer> numbers;
    private List<Person> people;
    
    public LambdaReduce() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        people = new ArrayList<>();
        people.add(new Person("Ivan", "Sanchez", 27));
        people.add(new Person("John", "Doe", 33));
        people.add(new Person("Mary", "Jane", 18));
    }

    public int substractNumbersFromN(int n) {
        return numbers.stream()
            .reduce(n, (a, b) -> a - b);
    }

    public int sumAllNumbers() {
        return numbers.stream()
            .reduce(0, (a, b) -> a + b);
    }

    public int ageSum() {
        return people.stream()
            .map(Person::getAge)
            .reduce((a, b) -> a + b)
            .get();
    }

    public int ageSumWithAccumulator(int accumulator) {
        return people.stream()
            .map(Person::getAge)
            .reduce(accumulator, (a, b) -> a + b);
    }

    public void runExamples() {
        System.out.println("LambdaReduce\n");

        int ageSum = this.ageSum();
        System.out.println(ageSum);

        System.out.println("----------------------");

        int substraction = this.substractNumbersFromN(100);
        System.out.println(substraction);

        System.out.println("----------------------");

        int sumAllNumbers = this.sumAllNumbers();
        System.out.println(sumAllNumbers);

        System.out.println("----------------------");

        int ageSumWithAccumulator = this.ageSumWithAccumulator(20);
        System.out.println(ageSumWithAccumulator);
    }
}
