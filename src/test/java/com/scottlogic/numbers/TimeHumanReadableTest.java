package com.scottlogic.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TimeHumanReadableTest {
    @Test
    void getUnitValues() {
        assertEquals(Arrays.asList(2, 1, 1, 0, 4), TimeHumanReadable.getUnitValues(126147662));
    }

    @Test
    void formatDuration() {
        assertEquals("4 years, 1 hour, 1 minute and 2 seconds", TimeHumanReadable.formatDuration(126147662));
        assertEquals("13 hours, 14 minutes and 22 seconds", TimeHumanReadable.formatDuration(47662));
    }
}