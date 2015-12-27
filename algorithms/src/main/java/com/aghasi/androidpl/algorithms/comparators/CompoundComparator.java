package com.aghasi.androidpl.algorithms.comparators;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator {

    private final List _comparators = new ArrayList<>();


    public void addComparator(Comparator comparator) {

        _comparators.add(comparator);
    }

    public int compare(Object left, Object right) throws ClassCastException {
        int result = 0;

        for (Object _comparator : _comparators) {
            result = ((Comparator) _comparator).compare(left, right);
            if (result != 0) {
                break;
            }
        }

        return result;
    }
}