package com.hackerrank;

import com.hackerrank.easy.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> queries=new ArrayList<>();
        queries.add("ab");
        queries.add("abc");
        queries.add("bc");
        List<String> stringList=new ArrayList<>();
        stringList.add("ab");
        stringList.add("ab");
        stringList.add("abc");
        List<Integer> integers = Arrays.matchingStrings(stringList, queries);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
