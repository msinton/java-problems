package com.scottlogic.recursion;

public class DoesItEvaluateAll {

    static int[] results;

//    static int add(int a, int b, int c) {
//        return a + b + c;
//    }

    static int apply(int n, int parent) {

        if (results == null) {
            results = new int[n + 1];
            results[0] = 0;
            results[1] = 1;
            results[2] = 2;
        }

        System.out.println(parent + " child:\t" + n);

        if (n == 0 || (n >= 0 && results[n] > 0)) {
            System.out.println("--");
            return results[n];
        }

        if (n <= 0) {
            return 0;
        } else {
            int result = apply(n-1, n) + apply(n-2, n) + apply(n-3, n);
            results[n] = result;

            return result;
        }
    }
}

/*
11 child:	10
10 child:	9
9 child:	8
8 child:	7
7 child:	6
6 child:	5
5 child:	4
4 child:	3
3 child:	2
3 child:	1
3 child:	0
4 child:	2
4 child:	1
5 child:	3
5 child:	2
6 child:	4
6 child:	3
7 child:	5
7 child:	4
8 child:	6
8 child:	5
9 child:	7
9 child:	6
10 child:	8
10 child:	7
 */