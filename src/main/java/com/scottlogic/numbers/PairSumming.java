package com.scottlogic.numbers;

import java.util.Arrays;
import static java.util.function.Function.*;

import java.util.Map;
import java.util.stream.Collectors;

public class PairSumming {

    // we don't remove pair once used
    static Long howManyPairsSumTo(int target, int[] nums) {

        Map<Integer, Long> numCounts = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));

        return Arrays.stream(nums)
                .boxed()
                .map(x -> target - x)
                .collect(Collectors.groupingBy(identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .mapToLong(e -> numCounts.getOrDefault(e.getKey(), 0L) * e.getValue())
                .sum() / 2;
    }
}
