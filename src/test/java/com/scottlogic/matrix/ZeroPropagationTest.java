package com.scottlogic.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroPropagationTest {

    @Test
    void apply() {
        int[][] input = {
            {1, 2, 3},
            {4, 5, 6}
        };

        assertArrayEquals(input, ZeroPropagation.apply(input));

        input[0][1] = 0;

        int[][] expected = {
            {0, 0, 0},
            {4, 0, 6}
        };
        assertArrayEquals(expected, ZeroPropagation.apply(input));

        int[][] input2 = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };
        int[][] expected2 = {
                {0, 0, 0},
                {0, 5, 0},
                {0, 0, 0}
        };
        assertArrayEquals(expected2, ZeroPropagation.apply(input2));

    }

}