package com.scottlogic.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BestRouteTest {

    int[][] grid = {
            {0, 5, 0, 4, 1},
            {0, 5, 0, 4, 1},
            {0, 0, 0, 0, 1},
            {19, 0, 0, 1, 1},
            {1, 0, 0, 4, 1},
    };

    @Test
    void completeBestGridNodesTest() {

        BestRoute.Grid result = BestRoute.completeBestGridNodes(new BestRoute.Grid(grid));
        for (int[] ints : result.grid) {
            System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    @Test
    void apply() {
        assertEquals("NENNNEEE", BestRoute.apply(grid));
    }

}