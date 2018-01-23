package com.scottlogic.strings;

import java.util.stream.IntStream;

public class PangramChecker {

    public static boolean check(String sentence){
        if (sentence.length() < 26) return false;

        String lower = sentence.toLowerCase();
        return IntStream.range('a', 'z' + 1).allMatch(a -> lower.indexOf(a) >= 0);
    }
}
