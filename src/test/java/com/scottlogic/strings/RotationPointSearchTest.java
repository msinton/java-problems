package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationPointSearchTest {

    @Test
    void findTest() {

        String[] words = {
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };

        assertEquals(5, RotationPointSearch.find(words));
    }

    @Test
    void findTest2() {

        String[] words = {
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };

        assertEquals(6, RotationPointSearch.find(words));
    }

    @Test
    void findRecTest() {

        String[] words = {
                "ptolemaic",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };

        assertEquals(3, RotationPointSearch.findRec(words));
    }

    @Test
    void findRecTest2() {

        String[] words = {
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };

        assertEquals(6, RotationPointSearch.findRec(words));
    }

}