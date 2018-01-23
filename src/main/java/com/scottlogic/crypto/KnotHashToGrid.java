package com.scottlogic.crypto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KnotHashToGrid {

    static String hexToBinary(String h) {
        return Integer.toBinaryString(Integer.parseInt(h, 16));
    }

    static long countBinaryOnes(String binary) {
        return binary.chars().filter(c -> c == '1').count();
    }

    static long countHashOnes(String input) {
        String hash = KnotHash.apply(input);

        return Arrays.stream(hash.split(""))
                .map(KnotHashToGrid::hexToBinary)
                .mapToLong(KnotHashToGrid::countBinaryOnes)
                .sum();
    }

    static Stream<String> inputToRowInputs(String input) {
        return IntStream.range(0, 128)
                .mapToObj(i -> input + "-" + i);
    }

    static long countGridOnes(String input) {
        return inputToRowInputs(input)
                .mapToLong(KnotHashToGrid::countHashOnes)
                .sum();
    }

    // second part
    static class Coord {
        int x;
        int y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coord coord = (Coord) o;

            if (x != coord.x) return false;
            return y == coord.y;
        }
        

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }


    }

    static boolean isOne(Coord coord, List<String> binaries) {
        return binaries.get(coord.x).charAt(coord.y) == '1';
    }

    static Set<Coord> findNeighboursHelper(Coord test, List<String> binaries, List<Coord> remaining) {
        if (remaining.contains(test)) {
            remaining.remove(test);
            if (isOne(test, binaries)) {
                return findNeighbours(test, binaries, remaining);
            }
        }
        return new HashSet<>();
    }

    static Set<Coord> findNeighbours(Coord coord, List<String> binaries, List<Coord> remaining) {
        // right
        Set<Coord> results = new HashSet<>();
        results.add(coord);

        int newX = Math.min(coord.x + 1, 127);
        Coord right = new Coord(newX, coord.y);
        results.addAll(findNeighboursHelper(right, binaries, remaining));

        int newY = Math.min(coord.y + 1, 127);
        Coord down = new Coord(coord.x, newY);
        results.addAll(findNeighboursHelper(down, binaries, remaining));

        newX = Math.max(coord.x - 1, 0);
        Coord left = new Coord(newX, coord.y);
        results.addAll(findNeighboursHelper(left, binaries, remaining));

        newY = Math.max(coord.y - 1, 0);
        Coord up = new Coord(coord.x, newY);
        results.addAll(findNeighboursHelper(up, binaries, remaining));

        return results;
    }

    static long countGridRegions(String input) {
        List<String> binaries = inputToRowInputs(input)
                .map(KnotHash::apply)
                .map(s -> Arrays.stream(s.split(""))
                        .map(KnotHashToGrid::hexToBinary)
                        .map(binary -> String.format("%04d", Integer.parseInt(binary)))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());

        // there are 128 x 128
        // regions are 1s - can be repr as sets
        // adjoined by adjacent 1s
        // Start in middle are recursively build until all points considered

        List<Coord> remainingCoords = IntStream.range(0, 128)
                .boxed()
                .flatMap(x -> IntStream.range(0, 128).mapToObj(y -> new Coord(x, y)))
                .collect(Collectors.toList());

        int count = 0;

        while (!remainingCoords.isEmpty()) {
            Coord start = remainingCoords.iterator().next();
            remainingCoords.remove(start);

            if (isOne(start, binaries)) {
                Set<Coord> region = findNeighbours(start, binaries, remainingCoords);
                remainingCoords.removeAll(region);
                count++;
            }
        }

        return count;
    }
}
