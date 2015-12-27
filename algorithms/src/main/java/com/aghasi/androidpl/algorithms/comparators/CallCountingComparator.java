package com.aghasi.androidpl.algorithms.comparators;


import java.util.Comparator;

public final class CallCountingComparator implements Comparator {
    private final Comparator _comparator;
    private int _callCount;


    public CallCountingComparator(Comparator comparator) {

        _comparator = comparator;
        _callCount = 0;
    }


    public int compare(Object left, Object right) throws ClassCastException {
        ++_callCount;
        return _comparator.compare(left, right);
    }


    public int getCallCount() {
        return _callCount;
    }
}
