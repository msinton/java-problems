package com.scottlogic.collections;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    public Node<T> root;

    public Tree(T rootData) {
        root = new Node<>(rootData, null);
    }

    public static class Node<T> {
        public T data;
        public Node<T> parent;
        public List<Node<T>> children;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
            this.children = new ArrayList<>();
        }

        public Node<T> addChild(T child) {
            Node<T> node = new Node<>(child, this);
            children.add(node);
            return node;
        }
    }
}