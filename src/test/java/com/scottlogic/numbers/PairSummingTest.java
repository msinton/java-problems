package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.scottlogic.numbers.PairSumming.howManyPairsSumTo;

class PairSummingTest {
    @Test
    void howManyPairsSumToTest() {
        assertEquals(Long.valueOf(4), howManyPairsSumTo(5, new int[] {1, 3, 2, 1, 4, -1, 0, 1} ));
    }

}