package com.aghasi.androidpl.algorithms.comparators;


import java.util.Comparator;

public class FixedComparator implements Comparator {

    private final int _result;


    public FixedComparator(int result) {
        _result = result;
    }

    public int compare(Object left, Object right) throws ClassCastException {
        return _result;
    }
}