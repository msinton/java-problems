package com.scottlogic.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StripComments {

    private static String stripComment(String line, String[] commentSymbols) {
        Optional<Integer> firstCommentSymbol = Stream.of(commentSymbols)
                .map(line::indexOf)
                .filter(i -> i != -1)
                .min(Comparator.naturalOrder());

        return firstCommentSymbol.map(i -> line.substring(0, i)).orElse(line);
    }

    public static String stripComments(String text, String[] commentSymbols) {
        return Stream.of(text.split("\n"))
                .map(l -> StripComments.stripComment(l, commentSymbols))
                .collect(Collectors.joining("\n"));
    }

    public static String alternative(String text, String[] commentSymbols) {

        String pattern = String.format("\\s[%s].*$", Arrays.stream(commentSymbols).collect(Collectors.joining()));

        return Stream.of(text.split("\n"))
                .map(s -> s.replaceAll(pattern, ""))
                .collect(Collectors.joining("\n"));
    }
}
