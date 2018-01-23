package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstSingleCharTest {

    @Test
    void testRun() {
        assertTrue(FirstSingleChar.run("abc").get() == 'a');
        assertTrue(FirstSingleChar.run("abca").get() == 'b');
        assertTrue(FirstSingleChar.run("abcab").get() == 'c');
        assertTrue(FirstSingleChar.run("zazxcva").get() == 'x');
        assertFalse(FirstSingleChar.run("abcabc").isPresent());
    }

    @Test
    void testRunWithStream() {
        assertTrue(FirstSingleChar.runWithStream("abc").get() == 'a');
        assertTrue(FirstSingleChar.runWithStream("abca").get() == 'b');
        assertTrue(FirstSingleChar.runWithStream("abcab").get() == 'c');
        assertEquals(FirstSingleChar.runWithStream("zazxcva").get(), Character.valueOf('x'));
        assertFalse(FirstSingleChar.runWithStream("abcabc").isPresent());
    }

    @Test
    void te(){
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        List<Object> objs = (List) ints;
        objs.add("hello");
        System.out.println(objs.get(0));
        System.out.println(objs.get(1));
    }

}