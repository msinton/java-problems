package com.scottlogic.sequences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scanner {

    static class ScanData {
        int layer;
        int range;
        int position = 0;
        boolean goingDown = true;

        public ScanData(int layer, int range) {
            this.layer = layer;
            this.range = range;
        }

        public int move(int steps) {
            while (steps > 0) {
                move();
                steps--;
            }
            return position;
        }

        public int move() {
            this.position += Math.min(range - 1, goingDown ? 1 : -1);
            if (this.position == range - 1 || this.position == 0) {
                goingDown = !goingDown;
            }
            return position;
        }

        ScanData copy() {
            ScanData s = new ScanData(this.layer, this.range);
            s.position = this.position;
            s.goingDown = this.goingDown;
            return s;
        }

        @Override
        public String toString() {
            return this.layer + ": " + this.position;
        }

    }

    static int scannerCost(ScanData scanner) {
        return scanner.position == 0 ? scanner.layer * scanner.range : 0;
    }

    static int cost(List<ScanData> scanners) {

        int cost = 0;
        int previousLayer = 0;

        List<ScanData> scannersCopy = scanners.stream().map(ScanData::copy).collect(Collectors.toList());

        for (ScanData scanner: scannersCopy) {
            int steps = scanner.layer - previousLayer;
            scannersCopy.forEach(s -> s.move(steps));
            cost += scannerCost(scanner);
            previousLayer = scanner.layer;
        }

        return cost;
    }

    static boolean caught(List<ScanData> scanners) {

        int previousLayer = 0;

        List<ScanData> scannersCopy = scanners.stream().map(ScanData::copy).collect(Collectors.toList());

        for (ScanData scanner: scannersCopy) {
            int steps = scanner.layer - previousLayer;
            scannersCopy.forEach(s -> s.move(steps));

            boolean caught = scanner.position == 0;
            if (caught) return true;
            previousLayer = scanner.layer;
        }

        return false;
    }

    static int calculateDelayForZeroCost(List<ScanData> scanners) {

        int delay = 0;

        while(caught(scanners)) {
            delay++;
            scanners.forEach(ScanData::move);
        }

        return delay;
    }

}
