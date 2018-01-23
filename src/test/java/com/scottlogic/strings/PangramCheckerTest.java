package com.scottlogic.strings;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PangramCheckerTest {

    @Test
    void check() {
        assertEquals(false, PangramChecker.check("The quick brown fox jumps over the lay dog"));
        assertEquals(true, PangramChecker.check("The quick brown fox jumps over the lazy dog"));
    }

}