package com.scottlogic.strings;

import java.util.Arrays;
import java.util.List;

public class ValidPasswords {

    interface Functions {
        static boolean containsNoDuplicates(String input) {
            String[] words = input.split("\\s");
            return Arrays.stream(words).distinct().count() == Arrays.stream(words).count();
        }
    }

    static long apply(List<String> inputs) {
         return inputs.stream().filter(Functions::containsNoDuplicates).count();
    }
}
