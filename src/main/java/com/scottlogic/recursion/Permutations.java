package com.scottlogic.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    static List<String> permutations(String s){

        List<String> results = new ArrayList<>();
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        String h = s.substring(0, 1);
        String rest = s.substring(1);

        List<String> sets = permutations(rest);
        results.addAll(sets);
        results.addAll(permutations(rest).stream()
                .map(p -> h + p)
                .collect(Collectors.toList()));

        return results;
    }


    static Set<String> removeOnePerm(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(i -> str.substring(0, i) + str.substring(i + 1))
                .collect(Collectors.toSet());
    }

    // Note that this does involve unnecessary work - since, after removing ONE char, the
    // next iteration will result in duplicates
    static List<String> powerSetLargestFirst(String s) {

        List<String> results = new ArrayList<>();
        int n = s.length();
        Set<String> next = new HashSet<>();
        next.add(s);
        results.add(s);

        while (n > 1) {
            next = next.stream()
                    .flatMap(str -> removeOnePerm(str).stream())
                    .collect(Collectors.toSet());

            results.addAll(next);
            n--;
        }

        return results;
    }

    public static Set<String> powerSet(String s) {
        Set<String> sets = new HashSet<>();
        if (s.isEmpty()) {
            sets.add("");
            return sets;
        }

        String head = s.substring(0, 1);
        String rest = s.substring(1);
        for (String set : powerSet(rest)) {
            sets.add(head + set);
            sets.add(set);
        }
        return sets;
    }


}
