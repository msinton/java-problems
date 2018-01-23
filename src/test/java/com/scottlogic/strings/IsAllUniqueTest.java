package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsAllUniqueTest {

    @Test
    void run() {
        String s1 = "absdfl;kje";
        String s2 = "absdfl;kjel";

        assertTrue(IsAllUnique.run(s1));
        assertFalse(IsAllUnique.run(s2));
    }

    @Test
    void runWithNoOtherDataStructures() {
        String s1 = "absdfl;kje";
        String s2 = "absdfl;kjel";
        String s3 = "absdfll;kje";

        assertTrue(IsAllUnique.runWithNoOtherDataStructures(s1));
        assertFalse(IsAllUnique.runWithNoOtherDataStructures(s2));
        assertFalse(IsAllUnique.runWithNoOtherDataStructures(s3));
    }

    @Test
    void runStream() {
        String s1 = "absdfl;kje";
        String s2 = "absdfl;kjel";

        assertTrue(IsAllUnique.runStream(s1));
        assertFalse(IsAllUnique.runStream(s2));
    }

}