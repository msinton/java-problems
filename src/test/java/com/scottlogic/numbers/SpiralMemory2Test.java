package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMemory2Test {
    @Test
    void apply() {

        assertEquals(10, SpiralMemory2.apply(6));
        assertEquals(349975, SpiralMemory2.apply(347991));
    }

}