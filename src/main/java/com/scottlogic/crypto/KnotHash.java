package com.scottlogic.crypto;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KnotHash {

    static int[] salt = {17, 31, 73, 47, 23};

    static class RoundResult {
        int index;
        int skipSize;
        int[] hashed;

        public RoundResult(int index, int skipSize, int[] hashed) {
            this.index = index;
            this.skipSize = skipSize;
            this.hashed = hashed;
        }
    }

    static int[] reverse(int[] list) {
        int[] result = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            result[i] = list[list.length - i - 1];
        }
        return result;
    }

    static int[] reverse(int[] list, int from, int to) {

        if (to > list.length) {
            // reversal wraps around
            int[] slice1 = Arrays.copyOfRange(list, from, list.length);
            int[] slice2 = Arrays.copyOfRange(list, 0, to % list.length);
            int[] reversedSlice = reverse(concat(slice1, slice2));
            for (int i = 0; i < to - from; i++) {
                list[(from + i) % list.length] = reversedSlice[i];
            }
        } else {
            int[] reversedSlice = reverse(Arrays.copyOfRange(list, from, to));
            System.arraycopy(reversedSlice, 0, list, from, reversedSlice.length);
        }
        return list;
    }

    static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    static RoundResult computeRound(int[] lengths, int[] list, int index, int skipSize) {

        for (int length : lengths) {
            if (length > list.length) {
                System.out.println("ooops");
                continue;
            }
            list = reverse(list, index, index + length);
            index = (index + length + skipSize) % list.length;
            skipSize += 1;
        }

        return new RoundResult(index, skipSize, list);
    }

    static int[] denseHash(int[] hash) {

        int size = hash.length / 16;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {

            int xors = hash[i*16];
            for (int j = 1; j < 16; j++) {
                xors ^= hash[i*16 + j];
            }
            result[i] = xors;
        }
        return result;
    }

    static String hashToHex(int[] hash) {
        StringBuilder builder = new StringBuilder();
        for (int b : hash) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    // assumes ints are bytes (in range of 0-256)
    static byte[] intsToBytes(int[] input) {
        byte[] result = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = (byte) input[i];
        }
        return result;
    }

    static RoundResult computeRounds(CharSequence input) {
        int[] list = IntStream.range(0, 256).toArray();
        int[] inLengths = input.chars().toArray();
        int[] lengths = concat(inLengths, salt);

        RoundResult result = new RoundResult(0, 0, list);
        int i = 0;
        while (i < 64) {
            result = computeRound(lengths, result.hashed, result.index, result.skipSize);
            i++;
        }
        return result;
    }

    static String apply(CharSequence input) {

        RoundResult result = computeRounds(input);

        return hashToHex(denseHash(result.hashed));
    }
}
