package com.scottlogic.strings;

import java.util.Arrays;

public class ReverseWords {

    static String apply(String sentence) {

        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        return Arrays.stream(sentence.split("\\s+"))
                .map(w -> new StringBuilder(w).reverse().toString())
                .reduce((String a, String b) -> a + " " + b)
                .orElse(sentence);
    }

    static String brokenGenerics() {

        String[] strings = new String[1];
        Object[] objects = strings;
        objects[0] = new Integer(1);

        String result = strings[0];
        return result;
    }
}
