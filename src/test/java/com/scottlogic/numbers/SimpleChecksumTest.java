package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleChecksumTest {
    @Test
    void apply() {

        System.out.println(SimpleChecksum.apply(SimpleChecksum.test));
        System.out.println(SimpleChecksum.apply(new int[][]{
                {1, 2, 3},
                {1, 2, 4}
        }));
    }

}