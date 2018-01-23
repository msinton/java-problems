package com.scottlogic.matrix;

import java.util.HashSet;
import java.util.Set;

public class ZeroPropagation {

    private static class Points {
        Set<Integer> xs;
        Set<Integer> ys;

        Points() {
            this.xs = new HashSet<>();
            this.ys = new HashSet<>();
        }
    }

    static Points findZeroes(int[][] matrix) {
        Points result = new Points();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    result.xs.add(i);
                    result.ys.add(j);
                }
            }
        }
        return result;
    }

    static int[][] apply(int[][] matrix) {

        Points zeroes = findZeroes(matrix);

        for(Integer zeroX: zeroes.xs) {
            for (int y = 0; y < matrix[zeroX].length; y++) {
                matrix[zeroX][y] = 0;
            }
        }
        for(Integer zeroY: zeroes.ys) {
            for (int x = 0; x < matrix.length; x++) {
                matrix[x][zeroY] = 0;
            }
        }

        return matrix;
    }
}
