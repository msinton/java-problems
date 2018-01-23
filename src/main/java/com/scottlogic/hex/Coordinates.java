package com.scottlogic.hex;

public class Coordinates {

    public static class GridRef {
        int x;
        int y;

        GridRef(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static GridRef of(int x, int y) {
            return new GridRef(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof GridRef) {
                GridRef that = (GridRef) obj;
                return that.y == this.y && that.x == this.x;
            }
            return false;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static int getChangeInY(int x, int dyWhenEven) {
        if (x % 2 == 0) {
            return dyWhenEven;
        }
        return dyWhenEven + 1;
    }

    static GridRef updatePosition(String direction, GridRef p) {
        switch (direction) {
            case "n": return GridRef.of(p.x, p.y - 1);
            case "s": return GridRef.of(p.x, p.y + 1);
            case "ne": return GridRef.of(p.x + 1, p.y + getChangeInY(p.x, -1));
            case "nw": return GridRef.of(p.x - 1, p.y + getChangeInY(p.x, -1));
            case "se": return GridRef.of(p.x + 1, p.y + getChangeInY(p.x, 0));
            case "sw": return GridRef.of(p.x - 1, p.y + getChangeInY(p.x, 0));
            default: throw new RuntimeException("bad direction " + direction);
        }
    }

    static GridRef getRef(String[] directions) {

        int maxDist = 0;

        GridRef position = GridRef.of(0,0);
        for (String direction: directions) {
            position = updatePosition(direction, position);

            maxDist = Math.max(distanceToHex(position), maxDist);
        }
        System.out.println("maxDist: " + maxDist);

        return position;
    }

    static int stepInDirection(int changeRequired) {
        if (changeRequired < 0) {
            return -1;
        } else if(changeRequired > 0) {
            return 1;
        }
        return 0;
    }

    static GridRef stepCloser(GridRef start, GridRef destination) {

        int dx = destination.x - start.x;
        int dy = destination.y - start.y;

        if (dy == 0) {
            return GridRef.of(start.x + stepInDirection(dx), start.y);
        }

        if (start.x % 2 == 0) {

            // y doesn't increase unless x stays same
            if (dy > 0) {
                if (dx == 0) {
                    return GridRef.of(start.x, start.y + 1);
                }
                return GridRef.of(start.x + stepInDirection(dx), start.y);
            } else {
                return GridRef.of(start.x + stepInDirection(dx), start.y + stepInDirection(dy));
            }
        } else {

            // y doesn't decrease unless x stays same
            if (dy < 0) {
                if (dx == 0) {
                    return GridRef.of(start.x, start.y - 1);
                }
                return GridRef.of(start.x + stepInDirection(dx), start.y);
            } else {
                return GridRef.of(start.x + stepInDirection(dx), start.y + stepInDirection(dy));
            }
        }

    }

    static int distanceToHex(GridRef destination) {

        GridRef p = GridRef.of(0,0);
        int steps = 0;

        while (!p.equals(destination)) {
            p = stepCloser(p, destination);
            steps++;
        }
        return steps;
    }
}
