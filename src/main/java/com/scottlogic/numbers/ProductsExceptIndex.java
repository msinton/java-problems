package com.scottlogic.numbers;

import java.util.Arrays;

public class ProductsExceptIndex {

    static int[] getProductsOfAllIntsExceptAtIndex(int[] input) {

        int[] results = new int[input.length];
        Arrays.fill(results, 1);

        for (int index = 0; index < input.length; index++) {
            for (int i = 0; i < input.length; i++) {
                if (i != index)
                    results[i] *= input[index];
            }
        }

        return results;
    }


    static int[] getProductsBetter(int[] input) {

        int[] above = new int[input.length];
        int[] below = new int[input.length];
        int[] results = new int[input.length];

        above[0] = 1;
        below[0] = 1;

        for (int i = 0; i < input.length - 1; i++) {
            above[i+1] = above[i] * input[i];
            below[i+1] = below[i] * input[input.length - i - 1];
        }

        for (int i = 0; i < input.length; i++) {
            results[i] = above[i] * below[input.length - i - 1];
        }

        return results;
    }

    static int[] getProductsSpaceOpt(int[] input) {

        int[] otherHalf = new int[input.length - 1];

        otherHalf[0] = input[input.length-1];

        for (int i = 1; i < input.length - 1; i++) {
            input[i] *= input[i-1];
            otherHalf[i] = otherHalf[i-1] * input[input.length - i - 1];
        }

        input[input.length - 1] = input[input.length - 2];

        for (int i = otherHalf.length - 1; i > 0; i--) {
            input[i] = input[i-1] * otherHalf[otherHalf.length - i - 1];
        }

        input[0] = otherHalf[otherHalf.length-1];

        return input;
    }


    static int[] getProductsSpaceOpt2(int[] input) {

        int[] products = new int[input.length];

        // the trick here is using a variable in order to offset setting the next product
        // then the items are in the right positions in the array
        // we end up doing ONE more multiplication than we need to do.
        // This could be sorted with a do while or equivalent
        int productSoFar = 1;
        for (int i = 0; i < input.length; i++) {
            products[i] = productSoFar;
            productSoFar *= input[i];
        }

        productSoFar = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            products[i] *= productSoFar;
            productSoFar *= input[i];
        }

        return products;
    }
}
