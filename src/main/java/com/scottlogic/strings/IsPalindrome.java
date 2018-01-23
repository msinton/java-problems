package com.scottlogic.strings;

public class IsPalindrome {

    static boolean apply(String s) {

        int m = s.length() / 2;

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;

        // the more functional approach would be to split at m where m = (length + 1) / 2
        // reverse the second
        // (zip and) compare - to stop early you can do this recursively
        // if you don't zip then you need take care to stop when the second is empty
    }
}
