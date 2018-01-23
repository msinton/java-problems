package com.scottlogic.strings;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstSingleChar {

    static Optional<Character> run(String input) {

        Map<Character, Integer> results = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            results.put(c, results.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : results.entrySet()) {
            if (entry.getValue() == 1) {
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    static Optional<Character> runWithStream(String input) {

        return Arrays.stream(input.split(""))
            .collect(Collectors.toMap(Function.identity(), v -> 1, (a,b) -> a + b, LinkedHashMap::new))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(e -> e.getKey().charAt(0));
    }


    static Optional<Character> runWithStream2(String input) {

        return input.chars().boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 1, (a,b) -> a + b, LinkedHashMap::new))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(e -> (char) ((int) e.getKey()));
    }
}
