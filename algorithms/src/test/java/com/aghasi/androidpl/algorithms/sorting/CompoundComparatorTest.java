package com.aghasi.androidpl.algorithms.sorting;


import com.aghasi.androidpl.algorithms.comparators.CompoundComparator;
import com.aghasi.androidpl.algorithms.comparators.FixedComparator;

import junit.framework.TestCase;

public class CompoundComparatorTest extends TestCase {

    CompoundComparator _compoundComparator;

    @Override
    protected void setUp() throws Exception {

        _compoundComparator = new CompoundComparator();
        super.setUp();
    }

    public void testComparisonContinuesWhileEqual() {
        _compoundComparator.addComparator(new FixedComparator(0));
        _compoundComparator.addComparator(new FixedComparator(0));
        _compoundComparator.addComparator(new FixedComparator(0));

        assertTrue(_compoundComparator.compare("IGNORED", "IGNORED") == 0);
    }


    public void testComparisonStopsWhenLessThan() {
        _compoundComparator.addComparator(new FixedComparator(0));
        _compoundComparator.addComparator(new FixedComparator(0));
        _compoundComparator.addComparator(new FixedComparator(-57));
        _compoundComparator.addComparator(new FixedComparator(91));

        assertTrue(_compoundComparator.compare("IGNORED", "IGNORED") < 0);
    }


    public void testComparisonStopsWhenGreaterThan() {
        _compoundComparator.addComparator(new FixedComparator(0));
        _compoundComparator.addComparator(new FixedComparator(0));
        _compoundComparator.addComparator(new FixedComparator(91));
        _compoundComparator.addComparator(new FixedComparator(-57));

        assertTrue(_compoundComparator.compare("IGNORED", "IGNORED") > 0);
    }
}
