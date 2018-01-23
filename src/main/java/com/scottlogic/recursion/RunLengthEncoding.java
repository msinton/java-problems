package com.scottlogic.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class RunLengthEncoding {

    static class Encoding {
        char c;
        int occurrences;

        Encoding(char c, int occurrences) {
            this.c = c;
            this.occurrences = occurrences;
        }

        @Override
        public String toString() {
            return c + "" + occurrences;
        }
    }

    private static void enc(Deque<Encoding> encodings, int c) {
        if (!encodings.isEmpty() && encodings.peekLast().c == c) {
            encodings.peekLast().occurrences += 1;
        } else {
            encodings.addLast(new Encoding((char) c, 1));
        }
    }

    static String withEncodingClass(String input) {

        Deque<Encoding> encodings = new ArrayDeque<>();

        input.chars().forEach(c -> enc(encodings, c));

        return encodings.stream()
                .map(Encoding::toString)
                .collect(Collectors.joining());
    }


    // Recursive solution
    private static StringBuilder append(StringBuilder resultBuilder, char c, int occurrences) {
        resultBuilder.append(c);
        if (occurrences > 1) resultBuilder.append(occurrences);
        return resultBuilder;
    }

    private static String recursiveLoop(char c, int occurrences, StringBuilder resultBuilder, Deque<Character> rest) {
        if (rest.isEmpty()) {
            return append(resultBuilder, c, occurrences).toString();
        }

        Character next = rest.pop();
        if (next.equals(c)) {
            return recursiveLoop(c, occurrences + 1, resultBuilder, rest);
        }
        return recursiveLoop(next, 1, append(resultBuilder,  c, occurrences), rest);
    }

    static String recursive(String input) {
        if (input.isEmpty()) return "";
        Deque<Character> inputChars = new ArrayDeque<>();
        for (char c: input.toCharArray()) {inputChars.add(c);}

        return recursiveLoop(inputChars.pop(), 1, new StringBuilder(), inputChars);
    }
}
