package com.scottlogic.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class ContainsAnagramOf {

    public static boolean containsAnagramOf(String candidate, String str) {

        Map<Integer, Integer> charMap = candidate.chars()
                .boxed()
                .collect(Collectors.toMap(Function.identity(), c -> 1, (a, b) -> a + b));

        Map<Integer, Integer> strMap = str.chars()
                .boxed()
                .collect(Collectors.toMap(Function.identity(), c -> 1, (a, b) -> a + b));


        return charMap.entrySet().stream()
                .allMatch(entry -> strMap.getOrDefault(entry.getKey(), 0) >= entry.getValue());
    }

//    static class Dictionary {
//        private Map<String, List<String>> entries;
//
//        public Dictionary(String[] entries) {
//            this.entries = Arrays.stream(entries)
//                    .collect(Collectors.groupingBy(Dictionary::sortWord));
//        }
//
//        public boolean contains(String word) {
//            return entries.containsKey(word);
//        }
//
//        public List<String> get(String key) {
//            return entries.get(key);
//        }
//
//        public static String sortWord(String letters) {
//            char[] l = letters.toCharArray();
//            Arrays.sort(l);
//            return new String(l);
//        }
//
//    }
}
