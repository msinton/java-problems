package com.scottlogic.crypto;

import java.util.*;

// Not mine
public class Day10KnotHash {
    CircularArray carr;

    public Day10KnotHash() {
        carr = new CircularArray(256);
    }

    public static void main(String[] args) {
        Day10KnotHash app = new Day10KnotHash();
        List<Integer> input = Arrays.asList(106, 118, 236, 1, 130, 0, 235, 254, 59, 205, 2, 87, 129, 25, 255, 118);
//        String input2 =  "106,118,236,1,130,0,235,254,59,205,2,87,129,25,255,118";
        String input2 = "";

        List<Integer> sanitizedIn = new ArrayList<>();
        for (int i = 0; i < input2.length(); i++) {
            sanitizedIn.add(input2.codePointAt(i));
        }
        sanitizedIn.addAll(Arrays.asList(17, 31, 73, 47, 23));
        for (int i = 0; i < 64; i++) {
            for (int in : sanitizedIn) {
                app.carr.reverseSub(0, in);

            }
        }
        for (int i : app.carr.arr) {
            System.out.println(app.carr.get(i) + "---" + app.carr.arr[i]);
        }
//        Solution ===========================
        System.out.println(app.carr.arr[0] * app.carr.arr[1]);
    }

    class CircularArray {
        int[] arr;
        int offset = 0;
        private int skipSize = 0;

        public CircularArray(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }

        public int get(int i) {
            return arr[(i + offset) % arr.length];
        }

        public void reverseSub(int start, int length) {
            List<Integer> subArr = new LinkedList<>();
            for (int i = start; i < start + length; i++) {
                subArr.add(arr[(i + offset) % arr.length]);
            }
            Collections.reverse(subArr);
            int j = 0;
            for (int i = start; i < start + length; i++) {
                arr[(i + offset) % arr.length] = subArr.get(j);
                j++;
            }
            offset += length + skipSize++;
        }
    }
}