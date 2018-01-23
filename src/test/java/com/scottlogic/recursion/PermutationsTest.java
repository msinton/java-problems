package com.scottlogic.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {
    @Test
    void permutations() {

        Set<String> expected = Stream.of(12345, 1345, 1235, 2345, 1245, 1234, 145, 134, 123, 135, 245, 234, 124, 345, 235, 125, 45, 34, 23, 12, 13, 35, 24, 14, 25, 15, 1, 2, 3, 4, 5)
                .map(String::valueOf).collect(Collectors.toSet());

        Set<String> result = new HashSet<>(Permutations.powerSetLargestFirst("12345"));

        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

}