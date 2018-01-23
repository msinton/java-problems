package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {
    @Test
    void ofSameChars() {
        System.out.println(LongestSubstring.ofSameChars("aabbbsssssfffddd").get().index);
    }

}