package com.scottlogic.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void runTest() {
        assertTrue(Fibonacci.runSimple(0) == 0);
        assertTrue(Fibonacci.runSimple(1) == 1);
        assertTrue(Fibonacci.runSimple(2) == 1);
        assertTrue(Fibonacci.runSimple(3) == 2);
        assertTrue(Fibonacci.runSimple(4) == 3);
        assertTrue(Fibonacci.runSimple(5) == 5);
        assertTrue(Fibonacci.runSimple(6) == 8);
//        assertEquals(3736710778780434371L, Fibonacci.runSimple(100));
        // gets stuck
    }

    @Test
    void run_goodComplexityTest() {
        assertTrue(Fibonacci.run_goodComplexity(0) == 0);
        assertTrue(Fibonacci.run_goodComplexity(1) == 1);
        assertTrue(Fibonacci.run_goodComplexity(2) == 1);
        assertTrue(Fibonacci.run_goodComplexity(3) == 2);
        assertTrue(Fibonacci.run_goodComplexity(4) == 3);
        assertTrue(Fibonacci.run_goodComplexity(5) == 5);
        assertTrue(Fibonacci.run_goodComplexity(6) == 8);
        assertEquals(3736710778780434371L, Fibonacci.run_goodComplexity(100));
    }

    @Test
    void runTailRec() {
        assertEquals(8, Fibonacci.fibonacci(6));
        assertEquals(3736710778780434371L, Fibonacci.fibonacci(100));
    }
}