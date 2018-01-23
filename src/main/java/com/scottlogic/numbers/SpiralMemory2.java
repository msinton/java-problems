package com.scottlogic.numbers;

import java.util.HashMap;
import java.util.Map;

public class SpiralMemory2 {

    static Map<Point, Integer> pointMap = new HashMap<>();

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null && obj instanceof Point) {
                Point that = (Point) obj;
                return this.x == that.x && this.y == that.y;
            }
            return false;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static int totalOfNeighbours(int x, int y) {
        return pointMap.getOrDefault(new Point(x - 1, y), 0) +
                pointMap.getOrDefault(new Point(x - 1, y + 1), 0) +
                pointMap.getOrDefault(new Point(x - 1, y - 1), 0) +
                pointMap.getOrDefault(new Point(x, y + 1), 0) +
                pointMap.getOrDefault(new Point(x, y - 1), 0) +
                pointMap.getOrDefault(new Point(x + 1, y - 1), 0) +
                pointMap.getOrDefault(new Point(x + 1, y + 1), 0) +
                pointMap.getOrDefault(new Point(x + 1, y), 0);
    }

    static int findExceeding(int target) {

        int x = 0;
        int y = 0;
        pointMap.clear();
        pointMap.put(new Point(0, 0), 1);

        int cycleIndex = 0;
        int pathLength = 1;

        int currentValue = 1;
        while (currentValue <= target) {

            for (int pathIndex = 0; pathIndex < pathLength && currentValue < target; pathIndex++) {

                if (cycleIndex % 4 == 0) { // on the right
                    x++;
                } else if (cycleIndex % 4 == 1) { // top
                    y--;
                } else if (cycleIndex % 4 == 2) { // left
                    x--;
                } else if (cycleIndex % 4 == 3) { // bottom
                    y++;
                }

                currentValue = totalOfNeighbours(x, y);
//                System.out.println("x y " + x + " " + y);
//                System.out.println(currentValue);
                pointMap.put(new Point(x, y), currentValue);
            }

            if (cycleIndex % 2 == 1) {
                pathLength++;
            }
            cycleIndex++;

        }
        return currentValue;
    }

    static int apply(int target) {

        return findExceeding(target);
    }
}
