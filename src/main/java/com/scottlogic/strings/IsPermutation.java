package com.scottlogic.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// aka IsAnagram
public class IsPermutation {

    static boolean run(String s1, String s2) {

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);
    }

    static boolean runUsingCounts(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int[] counts = new int[256]; // assuming ascii

        for (char c : s1.toCharArray()) {
            counts[c]++;
        }

        for (char c : s2.toCharArray()) {
            counts[c]--;
            if (counts[c] < 0) return false;
        }

        return true;
    }

    static boolean isAnagramNonAscii(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s1.toCharArray()) {
            counts.compute(c, (k, count) -> count == null ? 1 : count + 1);
        }

        for (char c : s2.toCharArray()) {
            Integer countResult = counts.compute(c, (k, count) -> count == null ? -1 : count - 1);
            if (countResult < 0) return false;
        }

        return true;
    }

    static boolean isAnagramStream(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        Map<Integer, Integer> counts1 = s1.chars()
                .boxed()
                .collect(
                    Collectors.toMap(Function.identity(), c -> 1, (a, b) -> a + b)
                );

        Map<Integer, Integer> counts2 = s2.chars()
                .boxed()
                .collect(
                        Collectors.toMap(Function.identity(), c -> 1, (a, b) -> a + b)
                );

        return counts1.equals(counts2);
    }

}
