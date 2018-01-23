package com.scottlogic.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void append() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(1);
        assertEquals(1, (int) list.getLast());
        assertEquals(list.getHead(), list.getLast());
        assertEquals(1, list.getSize());

        list.append(2);
        assertEquals(2, (int) list.getLast());
        assertEquals(1, (int) list.getHead());
        assertEquals(2, list.getSize());
    }

    @Test
    void deleteHead() {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(1);
        list.deleteHead();
        assertEquals(0, list.getSize());
    }

    @Test
    void deleteHeadWhenHave2() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // should be the first item added
        list.append(1);
        list.append(2);
        list.deleteHead();
        assertEquals(2, (int) list.getHead());
    }

    @Test
    void delete() {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.append(1);
        list.append(2);
        list.append(3);

        list.delete(1);

        assertEquals(1, (int) list.getHead());
        assertEquals(3, (int) list.getLast());
        assertEquals(2, list.getSize());

        list.append(4);
        list.append(5);

        list.delete(1);

        assertEquals(1, (int) list.getHead());
        assertEquals(5, (int) list.getLast());
        assertEquals(3, list.getSize());

        list.delete(0);
        assertEquals(4, (int) list.getHead());
        assertEquals(5, (int) list.getLast());
        assertEquals(2, list.getSize());
    }

}