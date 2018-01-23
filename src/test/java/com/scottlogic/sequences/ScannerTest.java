package com.scottlogic.sequences;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    @Test
    void cost() {
        List<Scanner.ScanData> scanners = Arrays.stream(input.split("\n"))
                .map(s -> s.split(": "))
                .map(arr -> new Scanner.ScanData(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])))
                .collect(Collectors.toList());

        assertEquals(1612, Scanner.cost(scanners));
    }

    @Test
    void calculateDelayForZeroCost() {
        List<Scanner.ScanData> scanners = Arrays.stream(input.split("\n"))
                .map(s -> s.split(": "))
                .map(arr -> new Scanner.ScanData(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])))
                .collect(Collectors.toList());

        assertEquals(1, Scanner.calculateDelayForZeroCost(scanners));
    }

    @Test
    void checkState() {
        List<Scanner.ScanData> scanners = Arrays.stream(test.split("\n"))
                .map(s -> s.split(": "))
                .map(arr -> new Scanner.ScanData(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])))
                .collect(Collectors.toList());

        scanners.forEach(s -> s.move(10));
        assertEquals(
                new ArrayList<>(Arrays.asList(2,0,2,2)),
                scanners.stream().map(s -> s.position).collect(Collectors.toList()));
    }

    @Test
    void test() {
        List<Integer> results = new ArrayList<>();
        results.stream().mapToInt(i -> i).toArray();
    }


    @Test
    void findMissingLetter() {

        char[] arr = new char[] { 'a','b','c','d','f'  };
        for (char c : arr) {

            System.out.println((int) c);
        }
    }


    String test = "0: 3\n" +
            "1: 2\n" +
            "4: 4\n" +
            "6: 4";

    String input = "0: 3\n" +
            "1: 2\n" +
            "2: 4\n" +
            "4: 6\n" +
            "6: 4\n" +
            "8: 6\n" +
            "10: 5\n" +
            "12: 6\n" +
            "14: 8\n" +
            "16: 8\n" +
            "18: 8\n" +
            "20: 6\n" +
            "22: 12\n" +
            "24: 8\n" +
            "26: 8\n" +
            "28: 10\n" +
            "30: 9\n" +
            "32: 12\n" +
            "34: 8\n" +
            "36: 12\n" +
            "38: 12\n" +
            "40: 12\n" +
            "42: 14\n" +
            "44: 14\n" +
            "46: 12\n" +
            "48: 12\n" +
            "50: 12\n" +
            "52: 12\n" +
            "54: 14\n" +
            "56: 12\n" +
            "58: 14\n" +
            "60: 14\n" +
            "62: 14\n" +
            "64: 14\n" +
            "70: 10\n" +
            "72: 14\n" +
            "74: 14\n" +
            "76: 14\n" +
            "78: 14\n" +
            "82: 14\n" +
            "86: 17\n" +
            "88: 18\n" +
            "96: 26";

}