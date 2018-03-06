package com.scottlogic.strings;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramDictionary {

    static String[] dictionary = new String[] {
            "toe", "toes", "got", "toga", "other", "tog"
    };

    private Map<String, Set<String>> sortedDictionary;

    public static void main(String[] args) {
        AnagramDictionary sol = new AnagramDictionary();
        sol.longestAnagram("otge");
        sol.longestAnagram("otes");
        sol.longestAnagram("hello");
    }

    public AnagramDictionary () {
        this.sortedDictionary = initialiseDictionary();
    }

    public Set<String> longestAnagram(String str) {

        // creates all permutations of word mapped by string length
        Map<Integer, Set<String>> allPermutations = permutations(str);

        // iterate from longest permutations to smallest
        for (int length = str.length(); length > 0; length--) {

            Set<String> words = allPermutations.get(length);

            // get any permutations in our dictionary map?
            Set<String> matches = words.stream()
                    .filter(word -> sortedDictionary.containsKey(word))
                    .flatMap(word -> sortedDictionary.get(word).stream())
                    .collect(Collectors.toSet());

            if (!matches.isEmpty()) {
                System.out.println("Matches found:" + matches);
                return matches;
            }
        }

        System.out.println("No matches found.");
        return new HashSet<>();
    }

    // initialises dictionary map
    // key is sorted in character order
    // value is a set of all matching words from dictionary
    private Map<String, Set<String>> initialiseDictionary() {

        Map<String, Set<String>> sortedDictionary = new HashMap<>();

        for (String word : dictionary) {
            String sortedWord = sortString(word);

            Set<String> wordSet = sortedDictionary.getOrDefault(sortedWord, new HashSet<>());
            wordSet.add(word);
            sortedDictionary.put(sortedWord, wordSet);
        }
        return sortedDictionary;
    }

    // sorts string in order of chars
    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // creates all permutations of a string
    // organised by length
    private static Map<Integer, Set<String>> permutations(String word) {
        List<String> permutations = powerSet(sortString(word));
        permutations.remove("");
        return permutations.stream().collect(Collectors.groupingBy(s -> s.length(), Collectors.toSet()));
    }

    private static List<String> powerSet(String s) {

        if (s.isEmpty()) {
            List<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        String head = s.substring(0, 1);
        String tail = s.substring(1);

        List<String> set = powerSet(tail);
        set.addAll(powerSet(tail).stream().map(x -> head + x).collect(Collectors.toList()));
        return set;
    }
}
