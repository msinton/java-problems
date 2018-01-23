package com.scottlogic.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RLETest {
    @Test
    void apply() {
        assertEquals("a2b2c", RLE.apply("aabbc"));
    }

}