package com.scottlogic;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ArgeTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    void test() {
        assertEquals(3, Arge.findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
        assertEquals(1, Arge.findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
        assertEquals(-1, Arge.findEvenIndex(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, Arge.findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));
        assertEquals(-1, Arge.findEvenIndex(new int[]{-8505, -5130, 1926, -9026}));
        assertEquals(1, Arge.findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6, Arge.findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }

    @Test
    void isSquare() {
        assertEquals(false, Arge.isSquare(8));
        assertEquals(true, Arge.isSquare(9));
    }

    @Test
    void numOnesInBitRep() {
        assertEquals(5, Arge.numOnesInBitRep(1234));
    }

    @Test
    void sdf() {
        List<Integer> digits = ("" + 123).chars().mapToObj(x -> Integer.parseInt((char) x + "")).collect(Collectors.toList());
        System.out.println(digits);
    }
}