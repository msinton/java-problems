package com.scottlogic.graph;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pipes {

    static class Connection {
        String node;
        List<String> nodes;

        private Connection(String node, List<String> nodes) {
            this.node = node;
            this.nodes = nodes;
        }

        public static Connection of(String node, List<String> nodes) {
            return new Connection(node, nodes);
        }
    }

    static Pattern p = Pattern.compile("(.*) <-> (.*)");

    static Connection parse(String input) {
        Matcher m = p.matcher(input);
        m.find();
        return Connection.of(m.group(1), Arrays.stream(m.group(2).split(", ")).collect(Collectors.toList()));
    }

    static List<Connection> parseAll(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(Pipes::parse)
                .collect(Collectors.toList());
    }

    static List<Set<String>> getConnectedGroups(Connection c, List<Set<String>> groups) {
        return groups.stream()
                .filter(group -> (group.contains(c.node) || c.nodes.stream().anyMatch(group::contains)))
                .collect(Collectors.toList());
    }

    static int apply(List<Connection> connections) {

        List<Set<String>> groups = new ArrayList<>();

        for (Connection c: connections) {

            List<Set<String>> connectedGroups = getConnectedGroups(c, groups);

            if (connectedGroups.isEmpty()) {
                HashSet<String> newGroup = new HashSet<>();
                newGroup.add(c.node);
                newGroup.addAll(c.nodes);
                groups.add(newGroup);
            } else {
                groups.removeAll(connectedGroups);
                Set<String> merged = connectedGroups.stream().flatMap(Set::stream).collect(Collectors.toSet());
                merged.add(c.node);
                merged.addAll(c.nodes);
                groups.add(merged);
            }
        }

        System.out.println("-- " + groups.size());

        return groups.stream().filter(group -> group.contains("0")).findFirst().get().size();
    }
}
