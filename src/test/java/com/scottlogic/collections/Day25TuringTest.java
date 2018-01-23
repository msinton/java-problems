package com.scottlogic.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day25TuringTest {


    @Test
    void apply() {
        System.out.println(Day25Turing.apply(input, 12919244));
    }

    //"Begin in state A.\n" +
    //"Perform a diagnostic checksum after 12919244 steps.\n" +


    String input =
            "In state A:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state B.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 0.\n" +
            "    - Move ONE slot to the left.\n" +
            "    - Continue with state C.\n" +
            "\n" +
            "In state B:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the left.\n" +
            "    - Continue with state A.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state D.\n" +
            "\n" +
            "In state C:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state A.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 0.\n" +
            "    - Move ONE slot to the left.\n" +
            "    - Continue with state E.\n" +
            "\n" +
            "In state D:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state A.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 0.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state B.\n" +
            "\n" +
            "In state E:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the left.\n" +
            "    - Continue with state F.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the left.\n" +
            "    - Continue with state C.\n" +
            "\n" +
            "In state F:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state D.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 1.\n" +
            "    - Move ONE slot to the right.\n" +
            "    - Continue with state A.";
}