package com.scottlogic.numbers;

import java.util.function.BiFunction;

public class SpiralMemoryFunctional {

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

    static class Iteration {
        int index;
        Point p;

        Iteration(int index, Point p) {
            this.index = index;
            this.p = p;
        }
    }
    
    static Iteration iterateUp(Iteration iteration, int target, int length) {
        return iterate(iteration, target, length, (p, increase) -> new Point(p.x, p.y - increase));
    }

    static Iteration iterateDown(Iteration iteration, int target, int length) {
        return iterate(iteration, target, length, (p, increase) -> new Point(p.x, p.y + increase));
    }

    static Iteration iterateRight(Iteration iteration, int target, int length) {
        return iterate(iteration, target, length, (p, increase) -> new Point(p.x + increase, p.y));
    }

    static Iteration iterateLeft(Iteration iteration, int target, int length) {
        return iterate(iteration, target, length, (p, increase) -> new Point(p.x - increase, p.y));
    }

    static Iteration iterate(Iteration iteration, int target, int length, BiFunction<Point, Integer, Point> fn) {
        int maxIncrease = target - iteration.index;
        if (length > maxIncrease) {
            return new Iteration(target, fn.apply(iteration.p, maxIncrease));
        }
        return new Iteration(iteration.index + length, fn.apply(iteration.p, length));
    }
    
    static Point findCoord(int target) {
        Point p = new Point(0, 0);
        Iteration iteration = new Iteration(1, p);

        int cycleIndex = 0;
        int pathLength = 1;

        while (iteration.index < target) {

            switch (cycleIndex % 4) {
                case 0:
                    iteration = iterateRight(iteration, target, pathLength);
                    break;
                case 1:
                    iteration = iterateUp(iteration, target, pathLength);
                    pathLength++;
                    break;
                case 2:
                    iteration = iterateLeft(iteration, target, pathLength);
                    break;
                default:
                    iteration = iterateDown(iteration, target, pathLength);
                    pathLength++;
            }
            cycleIndex++;
        }

        return iteration.p;
    }

    static int apply(int target) {
        Point p = findCoord(target);
        return Math.abs(p.x) + Math.abs(p.y);
    }
}
