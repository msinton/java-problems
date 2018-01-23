package com.scottlogic.collections;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day25Turing {

    enum Bin {
        ZERO, ONE
    }

    static class OpResult {
        boolean left;
        Bin write;
        String stateId;

        public OpResult(boolean left, Bin write, String stateId) {
            this.left = left;
            this.write = write;
            this.stateId = stateId;
        }
    }

    static class State {
        String id;

        EnumMap<Bin, OpResult> ops = new EnumMap<>(Bin.class);

        State(String id, OpResult opForZero, OpResult opForOne) {
            this.id = id;
            ops.put(Bin.ZERO, opForZero);
            ops.put(Bin.ONE, opForOne);
        }

        static State of(String id, OpResult opForZero, OpResult opForOne) {
            return new State(id, opForZero, opForOne);
        }
    }

    static OpResult parseOp(String input) {
        Pattern writePatt = Pattern.compile("the value (.)");
        Matcher m = writePatt.matcher(input);
        m.find();
        Bin write = m.group(1).equals("1") ? Bin.ONE : Bin.ZERO;

        Pattern movePatt = Pattern.compile("Move ONE slot to the (.)");
        m = movePatt.matcher(input);
        m.find();
        boolean left = m.group(1).equals("l");

        Pattern statePatt = Pattern.compile("Continue with state (.)");
        m = statePatt.matcher(input);
        m.find();
        String state = m.group(1);

        return new OpResult(left, write, state);
    }

    static State parse(String input) {
        String id = input.charAt(0) + "";
        String[] splits = input.split("If the current value is ");

        return State.of(id, parseOp(splits[1]), parseOp(splits[2]));
    }

    static long apply(String input, int steps) {

        Map<String, State> states = Arrays.stream(input.split("In state "))
                .skip(1)
                .map(Day25Turing::parse)
                .collect(Collectors.toMap(s -> s.id, Function.identity()));

        Map<Integer, Bin> tape = new LinkedHashMap<>();

        State state = states.get("A");

        Bin current = Bin.ZERO;
        Integer index = 0;
        tape.put(index, current);

        for (int i = 0; i < steps; i++) {
            OpResult result = state.ops.get(current);
            tape.put(index, result.write);
            if (result.left) {
                index--;
            } else {
                index++;
            }
            state = states.get(result.stateId);
            current = tape.getOrDefault(index, Bin.ZERO);
        }

        return tape.values().stream().filter(b -> b == Bin.ONE).count();
    }
}

//3229811