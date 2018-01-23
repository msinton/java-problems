package com.scottlogic.numbers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HighestProduct {

    static int run(int[] input) {

        int targetNumOfInts = 3;

        PriorityQueue<Integer> highestNumbers = new PriorityQueue<>(targetNumOfInts + 1);
        for (int i = 0; i < 3; i++) {
            highestNumbers.offer(input[i]);
        }

        for (int i = 3; i < input.length; i++) {

            int x = input[i];
            if (highestNumbers.peek() < x) {
                highestNumbers.offer(x);
                highestNumbers.poll();
            }
        }

        return highestNumbers.stream().reduce(1, (x,y) -> x * y);
    }

    static int runWithNeg(int[] input) {

        int targetNumOfInts = 3;

        PriorityQueue<Integer> highestNumbers = new PriorityQueue<>(targetNumOfInts + 1);
        PriorityQueue<Integer> mostNegativeNumbers = new PriorityQueue<>(targetNumOfInts, Comparator.reverseOrder());
        for (int i = 0; i < 3; i++) {
            highestNumbers.offer(0);
            mostNegativeNumbers.offer(0);
        }

        for (int x : input) {
            if (x > 0 && highestNumbers.peek() < x) {
                highestNumbers.offer(x);
                highestNumbers.poll(); // ensure queue only contains 3 items by removing smallest

            } else if (mostNegativeNumbers.peek() > x) {
                mostNegativeNumbers.offer(x);
                mostNegativeNumbers.poll();
            }
        }

        Integer[] high = new Integer[targetNumOfInts];
        highestNumbers.toArray(high);

        Integer[] low = new Integer[targetNumOfInts];
        mostNegativeNumbers.toArray(low);

        int highCandidate = high[0] * high[1];
        int lowCandidate = low[1] * low[2];

        return high[2] * Math.max(highCandidate, lowCandidate);
    }
}
