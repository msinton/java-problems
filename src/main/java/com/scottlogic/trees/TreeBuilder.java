package com.scottlogic.trees;

import com.scottlogic.collections.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class TreeBuilder {

    static class Properties {
        int weight;
        List<String> children;

        Properties(int weight, List<String> children) {
            this.children = children;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "weight " + weight + " children " + children;
        }
    }

    static class MyNode {
        String name;
        int weight;
        int weightSum;

        MyNode(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return name + " weight " + weight + " sum " + weightSum;
        }
    }

    static Pattern p = Pattern.compile("(\\w+).+?(\\d+)\\)(.*)");

    static List<String> parseChildren(String s) {
        if (s.isEmpty()) return new ArrayList<>();
        return Arrays.stream(s.replaceFirst(".*-> ", "").split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    static String[] parse(String s) {

        Matcher matcher = p.matcher(s);
        if (matcher.find()) {
            return new String[]{matcher.group(1), matcher.group(2), matcher.group(3)};
        } else {
            throw new RuntimeException("failed parse: " + s);
        }
    }

    static String findRoot(Map<String, Properties> input) {

        List<String> children = input.entrySet().stream()
                .filter(e -> !e.getValue().children.isEmpty())
                .flatMap(e -> e.getValue().children.stream())
                .collect(Collectors.toList());

        return input.entrySet().stream()
                .filter(e -> !e.getValue().children.isEmpty())
                .filter(e -> !children.contains(e.getKey()))
                .map(e -> e.getKey())
                .collect(Collectors.toList()).get(0);
    }

    private static void recursiveBuild(Map<String, Properties> input, Tree.Node<MyNode> root, String rootName) {

        input.get(rootName)
                .children
                .forEach(childName -> recursiveBuild(
                        input,
                        root.addChild(new MyNode(childName, input.get(childName).weight)), childName));
    }

    static int setWeightSums(Tree.Node<MyNode> root) {
        int sum = root.children.stream().map(TreeBuilder::setWeightSums).reduce(0, (a, b) -> a + b) + root.data.weight;
        root.data.weightSum = sum;
        return sum;
    }

    static Tree<MyNode> apply(Map<String, Properties> input) {

        String rootName = findRoot(input);
        Tree<MyNode> tree = new Tree<>(new MyNode(rootName, input.get(rootName).weight));

        recursiveBuild(input, tree.root, rootName);

        return tree;
    }

    static MyNode findBadNode(Tree.Node<MyNode> root) {

        Map<Integer, List<Tree.Node<TreeBuilder.MyNode>>> next = root.children.stream()
                .collect(Collectors.groupingBy(e -> e.data.weightSum));

        Optional<Tree.Node<TreeBuilder.MyNode>> node = next
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == 1)
                .map(e -> e.getValue().get(0))
                .findFirst();

        if (node.isPresent()) {
            node.get().parent.children.stream().forEach(m -> System.out.println("------------ " + m.data.weightSum));
            return findBadNode(node.get());
        }

        return root.data;
    }

}
