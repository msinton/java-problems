package com.scottlogic.numbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimeHumanReadable {

    private static List<String> unitNames = Arrays.asList("second", "minute", "hour", "day", "year");

    public static String format(String name, int units) {
        if (units == 0) return "";
        if (units == 1) return "1 " + name;
        return String.format("%d %ss", units, name);
    }

    public static String format(List<Integer> unitValues) {

        List<String> formattedUnits = IntStream.range(0, unitValues.size())
                .mapToObj(i -> format(unitNames.get(i), unitValues.get(i)))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        if (formattedUnits.size() == 1) return formattedUnits.get(0);

        List<String> tail = formattedUnits.stream().skip(1).collect(Collectors.toList());
        Collections.reverse(tail);
        return tail.stream().collect(Collectors.joining(", ")) + " and " + formattedUnits.get(0);
    }

    public static List<Integer> getUnitValuesLoop(int remainder, Queue<Integer> unitSizes, List<Integer> results) {

        if (remainder == 0) {
            return results;
        }

        int unitSize = unitSizes.poll();
        int unit = remainder % unitSize;

        int r = (remainder - unit) / unitSize;

        results.add(unit);
        return getUnitValuesLoop(r, unitSizes, results);
    }

    public static List<Integer> getUnitValues(int seconds) {
        return getUnitValuesLoop(seconds, new ArrayDeque<>(Arrays.asList(60, 60, 24, 365, 100)), new ArrayList<>());
    }

    public static String formatDuration(int seconds) {
        if (seconds <= 0) return "now";

        List<Integer> unitValues = getUnitValues(seconds);

        return format(unitValues);
    }
}
