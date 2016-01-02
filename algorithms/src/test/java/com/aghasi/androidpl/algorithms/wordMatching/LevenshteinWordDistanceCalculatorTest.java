package com.aghasi.androidpl.algorithms.wordMatching;

import junit.framework.TestCase;

public class LevenshteinWordDistanceCalculatorTest extends TestCase {

    private LevenshteinWordDistanceCalculator _calculator;

    protected void setUp() throws Exception {
        super.setUp();

        _calculator = LevenshteinWordDistanceCalculator.DEFAULT;
    }

    public void testEmptyToEmpty() {
        assertDistance(0, "", "");
    }

    public void testEmptyToNonEmpty() {
        String target = "any";
        assertDistance(target.length(), "", target);
    }

    public void testSamePrefix() {
        assertDistance(3, "unzip", "undo");
    }

    public void testSameSuffix() {
        assertDistance(4, "eating", "running");
    }

    public void testArbitrary() {
        assertDistance(3, "msteak", "mistake");
        assertDistance(3, "necassery", "neccessary");
        assertDistance(5, "donkey", "mule");
    }

    private void assertDistance(int distance, String source, String target) {
        assertEquals(distance, _calculator.calculate(source, target));
        assertEquals(distance, _calculator.calculate(target, source));
    }
}