package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMemoryTest {

    @Test
    void apply() {
        assertEquals(-1, SpiralMemory.findCoord(16).x);
        assertEquals(-2, SpiralMemory.findCoord(16).y);
        assertEquals(480, SpiralMemory.apply(347991));
    }

}