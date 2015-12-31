package com.aghasi.androidpl.algorithms;


import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ListBinaryInserterTest extends TestCase {

    private static final int TEST_SIZE = 1023;

    private ListBinaryInsertor _inserter;
    private List _list;

    protected void setUp() throws Exception {
        super.setUp();

        _inserter = new ListBinaryInsertor();
        _list = new ArrayList<>(TEST_SIZE);
    }

    public void testAscendingInOrderInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            assertEquals(i, _inserter.insert(_list, new Integer(i)));
        }

        verify();
    }

    public void testDescendingInOrderInsertion() {
        for (int i = TEST_SIZE - 1; i >= 0; --i) {
            assertEquals(0, _inserter.insert(_list, new Integer(i)));
        }

        verify();
    }

    public void testRandomInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            _inserter.insert(_list, new Integer((int) (TEST_SIZE * Math.random())));
        }

        verify();
    }

    private void verify() {
        int previousValue = Integer.MIN_VALUE;

        for (Object item : _list) {
            int currentValue = ((Integer) item).intValue();
            assertTrue(currentValue >= previousValue);
            previousValue = currentValue;
        }
    }
}
