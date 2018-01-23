package com.scottlogic.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;

public class MyBST<T> {

    private final Comparator<? super T> comparator;

    public MyBST(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    static class Node<S> {
        Node<S> left;
        Node<S> right;
        S data;

        Node(S data) {
            this.data = data;
        }
    }

    private Node<T> head;

    void insertHelper(Node<T> n, Node<T> candidate) {
        if (comparator.compare(n.data, candidate.data) < 0) {
            if (candidate.left == null) {
                candidate.left = n;
            } else {
                insertHelper(n, candidate.left);
            }
        } else {
            if (candidate.right == null) {
                candidate.right = n;
            } else {
                insertHelper(n, candidate.right);
            }
        }
    }

    void insert(T x) {
        Node<T> n = new Node<>(x);
        if (head == null) {
            head = n;
        } else {
            insertHelper(n, head);
        }
    }

//    Iterator<T> getIterator() {
//        return new MyIterator();
//    }


//    class MyIterator implements Iterator<T> {
//
//        private Node<T> previousHead;
//        private Node<T> currentHead;
//
//        MyIterator() {
//            currentHead = head;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return currentHead != null;
//        }
//
//        @Override
//        public T next() {
//            Node<T> next = getLeftmost(currentHead);
//            if (next == currentHead) {
//                next = getLeftmost(next.right);
//            }
//            previousHead = currentHead;
//            currentHead = next.right == null ? previousHead : next.right;
//            return next.data;
//        }
//
//        private Node<T> getLeftmost(Node<T> node, Node<T> stopNode) {
//            Node<T> next = node;
//            while (next.left != null && next.left != stopNode) {
//                next = next.left;
//            }
//            return next;
//        }
//    }
}
