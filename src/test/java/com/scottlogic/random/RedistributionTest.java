package com.scottlogic.random;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RedistributionTest {

    Integer[] input = {4, 1, 15, 12, 0, 9, 9, 5, 5, 8, 7, 3, 14, 5, 12, 3};

    @Test
    void cyclesTillSameState() {
        assertEquals(5, Redistribution.cyclesTillSameState(new Integer[]{0,2,7,0}));
        assertEquals(6681, Redistribution.cyclesTillSameState(input));
    }

    @Test
    void cyclesBetweenSameState() {
        assertEquals(4, Redistribution.cyclesBetweenSameState(new Integer[]{0,2,7,0}));
        assertEquals(2392, Redistribution.cyclesBetweenSameState(input));
    }
}