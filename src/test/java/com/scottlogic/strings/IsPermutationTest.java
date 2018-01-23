package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPermutationTest {

    @Test
    void run() {
        String s1 = "abcdefghi";
        String s2 = "abcdefgh";
        String s3 = "abcdefghV";
        String s4 = "ibcdefgha";

        assertFalse(IsPermutation.run(s1, s2));
        assertFalse(IsPermutation.run(s1, s3));
        assertTrue(IsPermutation.run(s1, s4));
    }

    @Test
    void runUsingCounts() {
        String s1 = "abcdefghi";
        String s2 = "abcdefgh";
        String s3 = "abcdefghV";
        String s4 = "ibcdefgha";

        assertFalse(IsPermutation.runUsingCounts(s1, s2));
        assertFalse(IsPermutation.runUsingCounts(s1, s3));
        assertTrue(IsPermutation.runUsingCounts(s1, s4));
    }

    @Test
    void runNonAscii() {
        String s1 = "abcdefghi";
        String s2 = "abcdefgh";
        String s3 = "abcdefghV";
        String s4 = "ibcdefgha";

        assertFalse(IsPermutation.isAnagramNonAscii(s1, s2));
        assertFalse(IsPermutation.isAnagramNonAscii(s1, s3));
        assertTrue(IsPermutation.isAnagramNonAscii(s1, s4));
    }

    @Test
    void runStream() {
        String s1 = "abcdefghi";
        String s2 = "abcdefgh";
        String s3 = "abcdefghV";
        String s4 = "ibcdefgha";

        assertFalse(IsPermutation.isAnagramStream(s1, s2));
        assertFalse(IsPermutation.isAnagramStream(s1, s3));
        assertTrue(IsPermutation.isAnagramStream(s1, s4));
    }
}