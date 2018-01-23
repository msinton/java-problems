package com.scottlogic.strings;

public class RotationPointSearch {

    static int find(String[] words) {

        String first = words[0];
        int lowerBound = 0;
        int upperBound = words.length;

        int lengthBetween = upperBound - lowerBound;

        while (lengthBetween > 1) {

            int m = lowerBound + lengthBetween / 2;
            String test = words[m];

            if (test.compareTo(first) >= 0) {
                //search ahead
                lowerBound = m;
            } else {
                // search behind
                upperBound = m;
            }

            lengthBetween = upperBound - lowerBound;
        }

        return lowerBound + 1;
    }

    private static int recLoop(String[] words, String first, int lowerBound, int upperBound) {

        int lengthBetween = upperBound - lowerBound;
        if (lengthBetween <= 1) return upperBound;

        int m = lowerBound + lengthBetween / 2;

        if (words[m].compareTo(first) >= 0) {
            //search ahead
            return recLoop(words, first, m, upperBound);
        } else {
            // search behind
            return recLoop(words, first, lowerBound, m);
        }
    }

    static int findRec(String[] words) {
        return recLoop(words, words[0], 0, words.length);
    }
}
