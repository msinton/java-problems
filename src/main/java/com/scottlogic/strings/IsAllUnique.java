package com.scottlogic.strings;

import java.util.HashSet;

public class IsAllUnique {

    static boolean run(String s) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            int size = set.size();
            set.add(c);
            if (size == set.size()) return false;
        }

        return true;
    }

    static boolean runWithNoOtherDataStructures(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i + 1).contains(s.charAt(i) + "")) return false;
        }
        return true;
    }

    static boolean runStream(String s) {
        return s.length() == s.chars().distinct().count();
    }
}
