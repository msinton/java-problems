package com.scottlogic.strings;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestSubstring {

    static class Result {
        int index;
        char c;
        int length;
        Result(int index,
                char c,
                int length) {
            this.index = index;
            this.c = c;
            this.length = length;
        }
    }

    static Optional<Result> ofSameChars(String s) {
        Pattern p = Pattern.compile("(.)\\1*");
        Matcher m = p.matcher(s);

        Optional<Result> result = Optional.empty();
        while (m.find()) {
            int length = m.group(0).length();
            char c = m.group(1).charAt(0);
            int index = m.start();

            if (result.isPresent()) {
                result = result.map(r -> r.length < length ? new Result(index, c, length) : r);
            } else {
                result = Optional.of(new Result(index, c, length));
            }
        }
        return result;
    }
}
