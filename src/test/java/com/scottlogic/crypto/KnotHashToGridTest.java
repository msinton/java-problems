package com.scottlogic.crypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnotHashToGridTest {
    @Test
    void apply() {
        String input = "ffayrhll";
        assertEquals(8190L, KnotHashToGrid.countGridOnes(input));
    }

    @Test
    void part2() {
        String input = "ffayrhll";
        System.out.println(KnotHashToGrid.countGridRegions(input));
    }

}