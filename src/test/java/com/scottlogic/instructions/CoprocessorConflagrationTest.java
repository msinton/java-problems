package com.scottlogic.instructions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoprocessorConflagrationTest {
    @Test
    void apply() {
        System.out.println(CoprocessorConflagration.apply(input.split("\n")));
    }

    @Test
    void part2() {
        System.out.println(CoprocessorConflagration.part2(input.split("\n")));
    }

    String input = "set b 84\n" +
            "set c b\n" +
            "jnz a 2\n" +
            "jnz 1 5\n" +
            "mul b 100\n" +
            "sub b -100000\n" +
            "set c b\n" +
            "sub c -17000\n" +
            "set f 1\n" +
            "set d 2\n" +
            "set e 2\n" +
            "set g d\n" + // a
            "mul g e\n" + //
            "sub g b\n" + //
            "jnz g 2\n" + // -> b
            "set f 0\n" +
            "sub e -1\n" + // b
            "set g e\n" + //
            "sub g b\n" + //
            "jnz g -8\n" + // -> a
            "sub d -1\n" +
            "set g d\n" +
            "sub g b\n" +
            "jnz g -13\n" +
            "jnz f 2\n" +
            "sub h -1\n" +
            "set g b\n" +
            "sub g c\n" +
            "jnz g 2\n" +
            "jnz 1 3\n" +
            "sub b -17\n" +
            "jnz 1 -23";

    String input2 = "set b 84\n" +
            "set c b\n" +
            "jnz a 2\n" +
            "jnz 1 5\n" +
            "mul b 100\n" +
            "sub b -100000\n" +
            "set c b\n" +
            "sub c -17000\n" +
            "set f 1\n" +
            "set d 2\n" +
            "set e 2\n" + // c

            "set g d\n" + // a
            "mul g e\n" + //
            "sub g b\n" + //
            "jnz g 2\n" + // -> b

            "set f 0\n" +

            "sub e -1\n" + // b
            "set g e\n" + //
            "sub g b\n" + //

            "jnz g -8\n" + // -> a

            "sub d -1\n" +
            "set g d\n" +
            "sub g b\n" +
            "jnz g -13\n" + // -> c
            "jnz f 2\n" +
            "sub h -1\n" +
            "set g b\n" +
            "sub g c\n" +
            "jnz g 2\n" +
            "jnz 1 3\n" +
            "sub b -17\n" +
            "jnz 1 -23";
}