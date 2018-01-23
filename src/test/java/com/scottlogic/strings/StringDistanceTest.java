package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDistanceTest {
    @Test
    void isOneAway() {
        assertTrue(StringDistance.isOneAway("asdf", "asd"));
        assertTrue(StringDistance.isOneAway("asdf", "asdfg"));
        assertTrue(StringDistance.isOneAway("asdf", "asf"));
        assertTrue(StringDistance.isOneAway("asd", "asf"));

        assertFalse(StringDistance.isOneAway("asdh", "asf"));
        assertFalse(StringDistance.isOneAway("a", "asf"));
    }

}