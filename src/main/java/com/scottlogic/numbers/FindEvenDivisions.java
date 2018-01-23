package com.scottlogic.numbers;


import java.util.Optional;

public class FindEvenDivisions {

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static Optional<Pair> findPairThatDivideEvenly(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                // don't divide by ZERO
                if (input[i] != 0 && input[j] != 0 && (input[i] % input[j] == 0 || input[j] % input[i] == 0)) {
                    return Optional.of(new Pair(input[i], input[j]));
                }
            }
        }
        return Optional.empty();
    }

    // in this case there are only 2 numbers that evenly divide on each row
    static int apply(int[][] input) {

        int sum = 0;
        for (int[] ints : input) {

            Pair pair = findPairThatDivideEvenly(ints).get();
            sum += Math.max(pair.a / pair.b, pair.b / pair.a);
        }
        return sum;
    }
}
