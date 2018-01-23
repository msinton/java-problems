package com.scottlogic.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class RLE {

    static class Encoding {
        char c;
        int n;

        Encoding(char c, int n) {
            this.c = c;
            this.n = n;
        }

        void increment() {
            this.n += 1;
        }

        @Override
        public String toString() {
            String number = this.n > 1 ? String.valueOf(this.n) : "";
            return this.c + number ;
        }
    }

    static void update(Deque<Encoding> encodings, char c) {
        if (!encodings.isEmpty() && encodings.peekLast().c == c) {
            encodings.peekLast().increment();
        } else {
            encodings.addLast(new Encoding(c, 1));
        }
    }


    public static String apply(String s) {

        Deque<Encoding> encodings = new ArrayDeque<>();

        s.chars().forEach(c -> update(encodings, (char) c));

        return encodings.stream()
                .map(Encoding::toString)
                .collect(Collectors.joining());
    }
}
