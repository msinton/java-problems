package com.scottlogic;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Arge {

    public static int findEvenIndex(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        int sumSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sumSoFar == (sum - arr[i]) / 2) return i;
            sumSoFar += arr[i];
        }
        return -1;
    }

    public static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return Math.floor(sqrt) == sqrt;
    }

    static int find(int[] integers){

        Map<Boolean, List<Integer>> map = Arrays.stream(integers)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        return map.get(true).size() == 1 ? map.get(true).get(0) : map.get(false).get(0);
    }

    static int numOnesInBitRep(int n) {
        int sum = 0;
        for (int i = 0; i < 31; i++) {
            sum += (n >> i) & 1;
        }
        return sum;
    }

    public static String encrypt(final String text, final int n) {
        if (n <= 0) return text;
        String str1 = IntStream.range(0, text.length() / 2).boxed().map(i -> text.charAt(i * 2 + 1) + "").collect(Collectors.joining());
        String str2 = IntStream.range(0, (text.length() + 1) / 2).boxed().map(i -> text.charAt(i * 2) + "").collect(Collectors.joining());

        return encrypt(str1 + str2, n-1);
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (n <= 0) return encryptedText;
        String str1 = encryptedText.substring(0, encryptedText.length() / 2);
        String str2 = encryptedText.substring(encryptedText.length() / 2);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            builder.append(str2.charAt(i));
            builder.append(str1.charAt(i));
        }
        if (str2.length() > str1.length()) {
            builder.append(str2.charAt(str2.length() - 1));
        }

        return decrypt(builder.toString(), n-1);
    }

    public static String seriesSum(int n) {
        double total = IntStream.range(1, n).boxed().map(i -> 1D/(i * 3 + 1)).reduce((a,b) -> a + b).get() + 1;
        return String.format("%.2f", total);
    }

    public static boolean check(String str) {
        long xs = str.chars().filter(c -> c == (int)'x').count();
        long os = str.chars().filter(c -> c == (int)'o').count();
        return xs == os;
    }

    public static long digPow(int n, int p) {

        List<Integer> digits = ("" + n).chars().boxed().collect(Collectors.toList());

        double sum = IntStream.range(0, digits.size()).mapToDouble(i -> Math.pow(digits.get(i), p + i)).sum();
        long k = 1;
        while (n * k < sum) {
            k++;
        }
        return n * k == sum ? k : -1;
    }
}