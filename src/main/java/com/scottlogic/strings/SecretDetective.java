package com.scottlogic.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecretDetective {

    private static Integer updateCharIndex(char key, int prevIndex, Map<Character, Integer> map) {
        return map.compute(key, (k, v) -> Math.max(v, 1 + prevIndex));
    }

    public static String recoverSecret(char[][] triplets) {

        List<char[]> triples = Arrays.stream(triplets).collect(Collectors.toList());

        Map<Character, Integer> charIndexes = triples.stream()
                .flatMap(c -> Stream.of(c[0], c[1], c[2]))
                .collect(Collectors.toMap(Function.identity(), x -> 0, (x,y) -> x));

        while (!charIndexes.values().contains(charIndexes.size() - 1))
        triples.forEach(c -> {
            Integer prevIndex = charIndexes.get(c[0]);
            prevIndex = updateCharIndex(c[1], prevIndex, charIndexes);
            updateCharIndex(c[2], prevIndex, charIndexes);
        });

        return charIndexes.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue()))
                .map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining());
    }
}
