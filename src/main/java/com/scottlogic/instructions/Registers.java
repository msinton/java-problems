package com.scottlogic.instructions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Registers {

    private static Map<String, BiFunction<Integer, Integer, Boolean>> comparisonOps = new HashMap<>();
    static {
        comparisonOps.put("==", (a, b) -> a.equals(b));
        comparisonOps.put(">", (a, b) -> a > b);
        comparisonOps.put("<", (a, b) -> a < b);
        comparisonOps.put(">=", (a, b) -> a >= b);
        comparisonOps.put("<=", (a, b) -> a <= b);
        comparisonOps.put("!=", (a, b) -> !a.equals(b));
    }

    private Map<String, Integer> registry = new HashMap<>();

    private int maxValue = 0;

    private static int unaryOp(String op, int value) {
        if (op.equals("inc")) return value;
        return -value;
    }

    private static class Condition {
        String subject;
        String comparision;
        int target;

        public Condition(String subject, String comparision, int target) {
            this.subject = subject;
            this.comparision = comparision;
            this.target = target;
        }

        @Override
        public String toString() {
            return String.format("%s %s %d", subject, comparision, target);
        }
    }
    
    static class Command {
        String target;
        String operation;
        int amount;
        Condition condition;

        public Command(
                String target,
                String operation,
                int amount,
                Condition condition) {

            this.target = target;
            this.amount = amount;
            this.condition = condition;
            this.operation = operation;
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %s", target, operation, amount, condition);
        }
    }

    private static Command parse(String s) {
        Matcher m = Pattern.compile("^(.*) (.*) (.*) if (.*) (.*) (.*)$").matcher(s);
        if (m.find()) {
            Condition c = new Condition(m.group(4), m.group(5), Integer.parseInt(m.group(6)));
            return new Command(m.group(1), m.group(2), Integer.parseInt(m.group(3)), c);
        } else {
            throw new RuntimeException("could not parse " + s);
        }
    }

    private void updateRegistry(Command c) {
        Integer conditionSub = registry.getOrDefault(c.condition.subject, 0);
        if (comparisonOps.get(c.condition.comparision).apply(conditionSub, c.condition.target)) {
            int newVal = registry.compute(
                    c.target, (k, v) -> v == null ? unaryOp(c.operation, c.amount) : v + unaryOp(c.operation, c.amount));
            maxValue = Math.max(newVal, maxValue);
        }
    }

    int apply(List<String> input) {

        List<Command> commands = input.stream().map(Registers::parse).collect(Collectors.toList());
//        commands.forEach(System.out::println);

        commands.forEach(this::updateRegistry);

        System.out.println(maxValue);

        return registry.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .max(Comparator.naturalOrder())
                .get();
    }
}
