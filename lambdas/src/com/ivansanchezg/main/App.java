package com.ivansanchezg.main;

import com.ivansanchezg.lambdas.LambdaFilter;
import com.ivansanchezg.lambdas.LambdaForEach;
import com.ivansanchezg.lambdas.LambdaMap;
import com.ivansanchezg.lambdas.LambdaReduce;

import java.util.List;

public class App {
    public static void main(String[] args) {
        LambdaForEach lambdaForEach = new LambdaForEach();
        lambdaForEach.runExamples();
        
        System.out.println("\n**********************");

        LambdaFilter lambdaFilter = new LambdaFilter();
        lambdaFilter.runExamples();

        System.out.println("\n**********************");

        LambdaMap lambdaMap = new LambdaMap();
        lambdaMap.runExamples();

        System.out.println("\n**********************");

        LambdaReduce lambdaReduce = new LambdaReduce();
        lambdaReduce.runExamples();
    }
}
