package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromePermutationTest {

    @Test
    void apply() {
        assertFalse(IsPalindromePermutation.apply("12"));
        assertTrue(IsPalindromePermutation.apply("112"));
        assertTrue(IsPalindromePermutation.apply("1122"));

        assertTrue(IsPalindromePermutation.apply("12 2"));
    }

}