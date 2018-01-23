package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest {
    @Test
    void apply() {
        assertTrue(IsPalindrome.apply("abcba"));
        assertTrue(IsPalindrome.apply("abba"));
        assertFalse(IsPalindrome.apply("abca"));
        assertFalse(IsPalindrome.apply("abcdba"));
    }

}