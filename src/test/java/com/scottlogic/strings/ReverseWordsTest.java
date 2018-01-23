package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    @Test
    void testApply() {
        assertEquals("olleh dlrow !oy", ReverseWords.apply("hello world  yo!"));
        assertEquals("olleh", ReverseWords.apply("hello"));
        assertEquals("  ", ReverseWords.apply("  "));
        assertEquals("", ReverseWords.apply(null));
    }

    @Test
    void showBroken() {
        ReverseWords.brokenGenerics();
    }
}