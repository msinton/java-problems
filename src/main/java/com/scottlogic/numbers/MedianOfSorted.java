package com.scottlogic.numbers;

import java.util.Arrays;
import java.util.Optional;

public class MedianOfSorted {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 9};
        int[] arr2 = {5, 12, 14};

        Optional<Double> result = findMedian(arr1, arr2);

        System.out.println(result);
    }

    public static Optional<Double> findMedian(int[] arr1, int[] arr2) {
        // handle empty arrays

        if (arr1.length == 0 && arr2.length == 0) {
            return Optional.empty();
        }

        if (arr1.length == 0) {
            return Optional.of(median(arr2).median);
        }

        if (arr2.length == 0) {
            return Optional.of(median(arr1).median);
        }

        return Optional.of(median(arr1, arr2));
    }

    static double median(int[] arr1, int[] arr2) {

        if (arr2.length == 1) {
            return median(arr1, arr2[0]);
        }
        if (arr1.length == 1) {
            return median(arr2, arr1[0]);
        }

        MedianAndMid mm1 = median(arr1);
        MedianAndMid mm2 = median(arr2);

        int numToChop = Math.min(mm1.mid, mm2.mid);

        if (mm1.median < mm2.median) {
            int[] newArr1 = Arrays.copyOfRange(arr1, numToChop, arr1.length);
            int[] newArr2 = Arrays.copyOfRange(arr2, 0, arr2.length - numToChop);
            return median(newArr1, newArr2);
        } else {
            int[] newArr1 = Arrays.copyOfRange(arr1, 0, arr1.length - numToChop);
            int[] newArr2 = Arrays.copyOfRange(arr2, numToChop, arr2.length);
            return median(newArr1, newArr2);
        }
    }

    static double median(int[] arr, int x) {
        int mid = arr.length / 2;

        if (arr.length % 2 == 0) {
            int[] requiredElements = {arr[mid - 1], arr[mid], x};
            Arrays.sort(requiredElements);
            return median(requiredElements).median;
        } else {
            if (arr.length == 1) {
                return (arr[0] + x) / 2D;
            }
            int[] requiredElements = {arr[mid - 1], arr[mid], arr[mid + 1], x};
            Arrays.sort(requiredElements);
            return median(requiredElements).median;
        }
    }

    static MedianAndMid median(int[] arr) {
        int mid = arr.length / 2;
        if (arr.length % 2 == 0) {
            return new MedianAndMid((arr[mid - 1] + arr[mid]) / 2D, mid);
        }
        return new MedianAndMid(arr[mid], mid);
    }

    private static class MedianAndMid {
        double median;
        int mid;

        MedianAndMid(double median, int mid) {
            this.median = median;
            this.mid = mid;
        }
    }

}

