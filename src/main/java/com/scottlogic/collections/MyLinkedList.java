package com.scottlogic.collections;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private class Node<S> {
        Node<S> next;
        Node<S> prev;
        S element;

        Node(S s) {
            element = s;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node<T> head;

    private Node<T> last;

    private int size = 0;

    private void insert(Node<T> n, Node<T> previous, Node<T> next) {
        n.next = next;
        next.prev = n;
        n.prev = previous;
        previous.next = n;
    }

    private Node<T> getNode(int index) {

        if (index < (size / 2)) {
            Node<T> current = head;
            int i = 0;
            while(i < index) {
                current = current.next;
                i++;
            }
            return current;
        }

        Node<T> current = last;
        int i = size - 1;
        while(i > index) {
            current = current.prev;
            i--;
        }

        return current;
    }

    private void unlink(Node<T> element) {
        Node<T> prev = element.prev;
        Node<T> next = element.next;

        // set links on prev
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            element.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            element.next = null;
        }
        size--;
    }

    public void append(T t) {
        Node<T> node = new Node<>(t);

        if (size == 0) {
            head = node;
            last = node;
        } else if (size == 1) {
            head.next = node;
            node.prev = head;
            last = node;
        } else {
            insert(last, last.prev, node);
            last = node;
        }
        size++;
    }

    public T getHead() {
        return head.element;
    }

    public void deleteHead() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        unlink(head);
    }

    public void delete(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException();
        }
        unlink(getNode(index));
    }

    public T getLast() {
        return last.element;
    }

    public int getSize() {
        return size;
    }

}
