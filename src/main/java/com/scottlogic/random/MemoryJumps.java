package com.scottlogic.random;

public class MemoryJumps {

    static int apply(int[] input) {

        int sum = 0;
        int index = 0;

        try {
            while (true) {
                index += input[index]++;
                sum += 1;
            }

        } finally {
            return sum;
        }
    }

    static int ruleOfThree(int[] input) {
        int sum = 0;
        int index = 0;

        try {
            while (true) {
                int value = input[index];
                if (value < 3) {
                    index += input[index]++;
                } else {
                    index += input[index]--;
                }
                sum += 1;
            }

        } finally {
            return sum;
        }
    }
}
