package com.ivansanchezg.main;

import com.ivansanchezg.streams.GroupBy;
import com.ivansanchezg.streams.SortBy;

public class App {
    public static void main(String[] args) {
        GroupBy groupBy = new GroupBy();
        groupBy.runExamples();

        SortBy sortBy = new SortBy();
        sortBy.runExamples();
    }
}