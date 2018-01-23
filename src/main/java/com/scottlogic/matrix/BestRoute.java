package com.scottlogic.matrix;

public class BestRoute {

    enum Direction {
        north, south, west, east
    }

    static class Grid {
        int[][] grid;
        int x;
        int y;
        
        Grid(int[][] grid) {
            this.grid = new int[grid.length][grid.length];
            for (int i = 0; i < grid.length; i++) {
                this.grid[i] = grid[i].clone();
            }
        }

        int add(int v) {
            return grid[x][y] += v;
        }
        
        void setPosition(int r, int c) {
            x = r;
            y = c;
        }

        boolean step(Direction d) {
            switch (d) {
                case north:
                    if (x == 0) return false;
                    x -= 1;
                    return true;
                case east:
                    if (y == size() - 1) return false;
                    y += 1;
                    return true;
                case south:
                    if (x == size() - 1) return false;
                    x += 1;
                    return true;
                case west:
                    if (y == 0) return false;
                    y -= 1;
                    return true;
            }
            return false;
        }
        
        int size() {
            return grid.length;
        }

        int north() {
            if (x == 0) return 0;
            return grid[x - 1][y];
        }

        int east() {
            if (y == size() - 1) return 0;
            return grid[x][y + 1];
        }

        int south() {
            if (x == size() - 1) return 0;
            return grid[x + 1][y];
        }

        int west() {
            if (y == 0) return 0;
            return grid[x][y - 1];
        }
    }

    
    static Grid completeBestGridNodes(Grid grid) {
        // traverse in reverse
        // assume square grid for ease
        int size = grid.size();
        Grid result = new Grid(grid.grid);

        // traverse top right triangle inner
        result.setPosition(0, size - 1);
        boolean stepValid = result.step(Direction.west);
        while (stepValid) {
            // traverse from topRight of diagonal down to bottom left
            // taking max from its top and right and adding
            int x = result.x;
            int y = result.y;
            while (stepValid) {
                result.add(Math.max(result.north(), result.east()));
                stepValid = result.step(Direction.east) && result.step(Direction.south);
            }
            result.setPosition(x, y);
            stepValid = result.step(Direction.west);
        }

        result.setPosition(0, 0);
        stepValid = true;
        // traverse bottom left triangle inner
        while (stepValid) {
            int x = result.x;
            int y = result.y;
            while (result.step(Direction.south)) {
                result.add(Math.max(result.north(), result.east()));
                result.step(Direction.east);
            }
            result.setPosition(x, y);
            stepValid = result.step(Direction.south);
        }

        return result;
    }

    static StringBuilder stepAndBuildPath(Grid grid, Direction d, StringBuilder result) {
        boolean stepValid = grid.step(d);
        if (stepValid) {
            if (d == Direction.north) {
                result.append("N");
            }
            if (d == Direction.east) {
                result.append("E");
            }
        }
        return result;
    }

    static boolean isAtEndPosition(Grid grid) {
        return grid.x == 0 && grid.y == grid.size() - 1;
    }

    static String takeBestRoute(Grid completedGrid) {
        int size = completedGrid.size();
        StringBuilder result = new StringBuilder();

        completedGrid.setPosition(size - 1, 0);

        while(!isAtEndPosition(completedGrid)) {
            if (completedGrid.x == 0) { // the only way is east
                result = stepAndBuildPath(completedGrid, Direction.east, result);
            } else if (completedGrid.y == size - 1) { // the only way is north
                result = stepAndBuildPath(completedGrid, Direction.north, result);
            } else {

                if (completedGrid.north() > completedGrid.east()) {
                    result = stepAndBuildPath(completedGrid, Direction.north, result);
                } else {
                    result = stepAndBuildPath(completedGrid, Direction.east, result);
                }
            }
        }
        return result.toString();
    }

    static String apply(int[][] grid) {
        Grid completed = completeBestGridNodes(new Grid(grid));
        return takeBestRoute(completed);
    }
}
