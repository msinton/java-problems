package com.scottlogic.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunLengthEncodingTest {

    @Test
    void testWithEncodingClass() {
        assertEquals("", RunLengthEncoding.withEncodingClass(""));
        assertEquals("a1b2x3d1", RunLengthEncoding.withEncodingClass("abbxxxd"));
    }

    @Test
    void testRecursive() {
        assertEquals("", RunLengthEncoding.recursive(""));
        assertEquals("ab2x3d", RunLengthEncoding.recursive("abbxxxd"));
    }
}