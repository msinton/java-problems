package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestProductTest {

    @Test
    void highestProductTest() {

        int[] input = {1, 4, 6, 3, 2};

        assertEquals(4 * 6 * 3, HighestProduct.run(input));
    }

    @Test
    void highestProductWithNeg() {

        int[] input = {1, -4, 6, -3, 2};
        assertEquals(4 * 6 * 3, HighestProduct.runWithNeg(input));

        int[] input2 = {-1, -4, 6, 3};
        assertEquals(6 * 4, HighestProduct.runWithNeg(input2));
    }

}