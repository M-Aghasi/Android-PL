package com.aghasi.androidpl.algorithms.sorting;


import com.aghasi.androidpl.algorithms.comparators.NaturalComparator;

import junit.framework.TestCase;

public class NaturalComparatorTest extends TestCase {
    public void testLessThan() {
        assertTrue(NaturalComparator.INSTANCE.compare("A", "B") < 0);
    }

    public void testGreaterThan() {
        assertTrue(NaturalComparator.INSTANCE.compare("B", "A") > 0);
    }

    public void testEqualTo() {
        assertTrue(NaturalComparator.INSTANCE.compare("A", "A") == 0);
    }
}
