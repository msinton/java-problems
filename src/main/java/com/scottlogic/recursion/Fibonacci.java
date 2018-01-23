package com.scottlogic.recursion;

public class Fibonacci {

    static long runSimple(long n) {

        if (n == 0) return 0;
        if (n <= 2) return 1;
        return runSimple(n - 1) + runSimple(n - 2);
    }

    static long run_goodComplexity(long n) {

        if (n == 0) return 0;

        long i = 2;
        long value = 1;
        long prevValue = 1;

        while (i < n) {
            long temp = value;
            value += prevValue;
            prevValue = temp;
            i++;
        }
        return value;
    }

    // tail recursive
    private static long fibonacciRec(long n, long prev, long current) {
        if (n == 0) return current;
        else return fibonacciRec(n - 1, current, current + prev);
    }

    static long fibonacci(long n) {
        return fibonacciRec(n - 1, 0, 1);
    }
}
