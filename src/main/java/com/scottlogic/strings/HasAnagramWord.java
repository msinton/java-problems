package com.scottlogic.strings;

import java.util.Arrays;

public class HasAnagramWord {

    interface Functions {
        static String sort(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    static boolean containsAnagram(String sentence) {
        String[] words = sentence.split(" ");
        long nonAnagramCount = Arrays.stream(words)
                .map(Functions::sort)
                .distinct()
                .count();
        return nonAnagramCount != words.length;
    }

    static int apply(String[] passwords) {

        int sum = 0;
        for (String password : passwords) {
            if (!containsAnagram(password))
                sum += 1;
        }
        return sum;
    }

}
