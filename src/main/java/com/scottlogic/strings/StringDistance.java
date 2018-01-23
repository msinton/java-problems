package com.scottlogic.strings;

public class StringDistance {

    static boolean isOneAway(String s1, String s2) {
        
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;

        if (s1.length() < s2.length())
            return isOneAwayRemoved(s1, s2);

        if (s1.length() > s2.length())
            return isOneAwayRemoved(s2, s1);

        return hasLessThanOneEdit(s1, s2);
    }

    static boolean hasLessThanOneEdit(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(i+1).equals(s2.substring(i+1));
            }
        }
        return true;
    }

    static boolean isOneAwayRemoved(String shorterStr, String longerStr) {

        int offset = 0;
        for (int i = 0; i < shorterStr.length(); i++) {
            if (shorterStr.charAt(i) != longerStr.charAt(i + offset)) {
                i--;
                offset++;
                if (offset > 1) return false;
            }
        }
        return true;
    }
}