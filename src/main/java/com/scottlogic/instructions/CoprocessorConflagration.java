package com.scottlogic.instructions;

import java.util.*;
import java.util.stream.IntStream;

public class CoprocessorConflagration {

    static int callsToMult = 0;

    static Integer parseInstrValue(String value,  Map<String, Integer> registers) {
        if (value.matches("[a-z]")) {
            return registers.getOrDefault(value, 0);
        }
        return Integer.parseInt(value);
    }

    static void handleFirstLoop(Map<String, Integer> registers, boolean dIncreasesToBMinusOne) {
        Integer g = registers.getOrDefault("g", 0);
        if (g != 0) {
            Integer d = registers.getOrDefault("d", 0);
            Integer b = registers.getOrDefault("b", 0);

            if (dIncreasesToBMinusOne) {
                // for i in d_0 to b-1, if b % i == 0 then
                if (IntStream.range(d, b).anyMatch(i -> (b % i == 0) && (b / i) < b)) {
                    registers.put("f", 0);
                }
            }

            if (b % d == 0 && (b / d) < b) {
                registers.put("f", 0);
            }
            registers.put("g", 0);
            registers.put("e", b);
        }
    }

    static void handleSecondLoop(Map<String, Integer> registers) {
        Integer g = registers.getOrDefault("g", 0);
        if (g != 0) {
            registers.put("e", 2);
            handleFirstLoop(registers,  true);
            Integer b = registers.getOrDefault("b", 0);
            registers.put("d", b);
            registers.put("g", 0);
        }
    }

    static int updateRegistersAndReturnOffset(String instruction, Map<String, Integer> registers) {

        String[] split = instruction.split(" ");
        String command = split[0];
        String target = split[1];
        Integer value = parseInstrValue(split[2], registers);

        System.out.println(command + " " + target + " \t " + split[2] + ": " + value); // + " \n" + registers.get("g") + " \t" + registers.get("e"));

        if (instruction.equals("jnz g -8")) {
            handleFirstLoop(registers, false);
        }

        if (instruction.equals("jnz g -13")) {
            handleSecondLoop(registers);
        }

        if (command.equals("set")) {
            registers.put(target, value);
        }
        if (command.equals("sub")) {
            registers.compute(target, (k, v) -> v == null ? 0 - value : v - value);
        }
        if (command.equals("mul")) {
            registers.compute(target, (k, v) -> v == null ? 0 : v * value);
            callsToMult += 1;
        }
        if (command.equals("jnz")) {

            Integer targetValue = parseInstrValue(target, registers);
            if (targetValue != 0) {
                return value;
            }
        }

        return 1;
    }

    static int apply(String[] instructions) {

        Map<String, Integer> registers = new HashMap<>();

        int index = 0;
        while (index >= 0 && index < instructions.length) {
            index += updateRegistersAndReturnOffset(instructions[index], registers);
        }

        return callsToMult;
    }

    static int part2(String[] instructions) {

        Map<String, Integer> registers = new HashMap<>();

        registers.put("a", 1);

        int index = 0;
        while (index >= 0 && index < instructions.length) {
            index += updateRegistersAndReturnOffset(instructions[index], registers);
        }

        return registers.get("h");
    }
}
