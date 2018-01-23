package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductsExceptIndexTest {

    @Test
    void getProductsOfAllIntsExceptAtIndex() {
        int[] input = {1, 7, 3, 4};
        int[] expect = {84, 12, 28, 21};

        assertArrayEquals(expect, ProductsExceptIndex.getProductsOfAllIntsExceptAtIndex(input));
    }

    @Test
    void getProductsWhenZeros() {
        int[] input = {1, 7, 0, 4};
        int[] expect = {0, 0, 28, 0};

        assertArrayEquals(expect, ProductsExceptIndex.getProductsOfAllIntsExceptAtIndex(input));
    }

    @Test
    void getProductsBetter() {
        int[] input = {1, 7, 3, 4};
        int[] expect = {84, 12, 28, 21};

        assertArrayEquals(expect, ProductsExceptIndex.getProductsBetter(input));
    }

    @Test
    void getProductsBetterWhenZeros() {
        int[] input = {1, 7, 0, 4};
        int[] expect = {0, 0, 28, 0};

        assertArrayEquals(expect, ProductsExceptIndex.getProductsBetter(input));
    }

    @Test
    void getProductsSpaceOpt() {
        int[] input = {1, 7, 3, 4};
        int[] expect = {84, 12, 28, 21};

        assertArrayEquals(expect, ProductsExceptIndex.getProductsSpaceOpt2(input));
    }

    @Test
    void getProductsSpaceOptWhenZeros() {
        int[] input = {1, 7, 0, 4};
        int[] expect = {0, 0, 28, 0};

        assertArrayEquals(expect, ProductsExceptIndex.getProductsSpaceOpt2(input));
    }
}