package com.scottlogic.numbers;

import java.util.*;
import java.util.stream.Collectors;

public class DominoBridge {

    static List<Integer> results = new ArrayList<>();

    static int sum(Deque<Integer[]> bridge) {
        return bridge.stream().mapToInt(d -> d[0] + d[1]).sum();
    }

    static Integer[] parseDomino(String s) {
        String[] split = s.split("/");
        return new Integer[] {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }

    static Integer[] swap(Integer[] domino) {
        return new Integer[] {domino[1], domino[0]};
    }

    static Deque<Integer[]> attach(Integer[] domino, Deque<Integer[]> current, Integer joinTo) {
        current.addLast(domino[0].equals(joinTo) ? domino : swap(domino));
        return current;
    }

    static BranchData attachAndRemove(Integer[] domino, Deque<Integer[]> current, Integer joinTo, List<Integer[]> available) {
        List<Integer[]> clone = new ArrayList<>(available);
        clone.remove(domino);
        return BranchData.of(attach(domino, new ArrayDeque<>(current), joinTo), clone);
    }

    static List<BranchData> nextBranches(BranchData branchData) {

        Integer last = branchData.current.peekLast()[1];
        List<Integer[]> choices = branchData.available.stream()
                .filter(d -> d[0].equals(last) || d[1].equals(last))
                .collect(Collectors.toList());

        if (choices.isEmpty()) {
            Integer total = sum(branchData.current);
            System.out.println("--" + total);
            results.add(total);
            return new ArrayList<>();
        }

        return choices.stream()
                .map(c -> attachAndRemove(c, branchData.current, last, branchData.available))
                .collect(Collectors.toList());
    }

    static class BranchData {
        Deque<Integer[]> current;
        List<Integer[]> available;

        public BranchData(Deque<Integer[]> current, List<Integer[]> available) {
            this.current = current;
            this.available = available;
        }

        static BranchData of(Deque<Integer[]> current, List<Integer[]> available) {
            return new BranchData(current, available);
        }
    }

    static int apply(String[] input) {

        List<Integer[]> dominos = Arrays.stream(input)
                .map(DominoBridge::parseDomino)
                .collect(Collectors.toList());

        List<BranchData> branches = dominos.stream().filter(d -> d[0] == 0 || d[1] == 0)
                .map(d -> attachAndRemove(d, new ArrayDeque<>(), 0, dominos))
                .collect(Collectors.toList());

        while (!branches.isEmpty()) {
            System.out.println(branches.size());
            branches = branches.stream().flatMap(b -> nextBranches(b).stream()).collect(Collectors.toList());
        }

//        System.out.println(results);

        return results.stream().max(Comparator.naturalOrder()).get();
    }
}
