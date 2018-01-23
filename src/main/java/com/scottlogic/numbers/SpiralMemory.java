package com.scottlogic.numbers;


public class SpiralMemory {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static Point findCoord(int target) {
        int i = 1;
        int x = 0;
        int y = 0;

        int cycleIndex = 0;
        int pathLength = 1;

        while (i < target) {

            for (int pathIndex = 0; pathIndex < pathLength && i < target; pathIndex++) {

                if (cycleIndex % 4 == 0) {
                    x++;
                } else if (cycleIndex % 4 == 1) {
                    y--;
                } else if (cycleIndex % 4 == 2) {
                    x--;
                } else if (cycleIndex % 4 == 3) {
                    y++;
                }
                i++;
            }

            if (cycleIndex % 2 == 1) {
                pathLength++;
            }
            cycleIndex++;

        }
        return new Point(x, y);
    }

    static int apply(int target) {

        Point p = findCoord(target);

        return Math.abs(p.x) + Math.abs(p.y);
    }
}
