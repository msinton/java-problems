package com.scottlogic.random;

import java.util.*;
import java.util.stream.Collectors;

public class Redistribution {

    static int indexOfMax(List<Integer> ints) {
        int maxAt = 0;

        for (int i = 0; i < ints.size(); i++) {
            maxAt = ints.get(i) > ints.get(maxAt) ? i : maxAt;
        }
        return maxAt;
    }

    static List<Integer> redistribute(List<Integer> input) {
        int indexOfMax = indexOfMax(input);
        int value = input.get(indexOfMax);
        List<Integer> result = new ArrayList<>(input);
        result.set(indexOfMax, 0);

        for (int i = indexOfMax + 1; i < value + indexOfMax + 1; i++) {
            result.set(i % input.size(), result.get(i % input.size()) + 1);
        }

        return result;
    }

    static int cyclesTillSameState(Integer[] input) {

        LinkedHashSet<List<Integer>> statesSeen = new LinkedHashSet<>();
        List<Integer> nextState = Arrays.asList(input);

        int steps = 0;
        while(statesSeen.add(nextState)) {
            nextState = redistribute(nextState);
            steps += 1;
        }

        return steps;
    }

    static int cyclesBetweenSameState(Integer[] input) {
        LinkedHashSet<List<Integer>> statesSeen = new LinkedHashSet<>();
        List<Integer> nextState = Arrays.asList(input);

        while(statesSeen.add(nextState)) {
            nextState = redistribute(nextState);
        }

        int index = 0;
        boolean found = false;
        for(List<Integer> state : statesSeen) {
            if (state.equals(nextState)) {
                found = true;
            }
            if (found)
                index++;
        }
        return index;
    }
}
