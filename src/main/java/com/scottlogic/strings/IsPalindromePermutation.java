package com.scottlogic.strings;

import java.util.function.Function;
import java.util.stream.Collectors;

public class IsPalindromePermutation {

    static boolean apply(String s) {

        int space = ' ';

        return s.chars()
                .boxed()
                .filter(c -> !c.equals(space))
                .collect(Collectors.toMap(Function.identity(), c -> 1, (a, b) -> a + b))
                .values()
                .stream()
                .filter(Functions::isOdd)
                .count() <= 1;

    }

    interface Functions {

        static boolean isOdd(int n) {
            return n % 2 != 0;
        }
    }
}

