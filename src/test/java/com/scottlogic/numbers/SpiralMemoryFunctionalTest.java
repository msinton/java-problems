package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMemoryFunctionalTest {
    @Test
    void apply() {
        assertEquals(-1, SpiralMemoryFunctional.findCoord(16).x);
        assertEquals(-2, SpiralMemoryFunctional.findCoord(16).y);
        assertEquals(480, SpiralMemoryFunctional.apply(347991));
    }

}