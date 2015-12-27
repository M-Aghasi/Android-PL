package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;
import java.util.List;

public class ShellSortListSorter implements ListSorter {

    private final Comparator _comparator;

    private final int[] _hSortSequenceOfIncrement = {121, 40, 13, 4, 1};


    public ShellSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }


    public List sort(List list) {

        for (int increment : _hSortSequenceOfIncrement) {
            hSort(list, increment);
        }

        return list;
    }

    private void hSort(List list, int increment) {
        if (list.size() < (increment * 2)) {
            return;
        }

        for (int i = 0; i < increment; ++i) {
            sortSubList(list, i, increment);
        }
    }

    private void sortSubList(List list, int startIndex, int increment) {
        for (int i = startIndex + increment; i < list.size(); i += increment) {
            Object value = list.get(i);
            int j;
            for (j = i; j > startIndex; j -= increment) {
                Object previousValue = list.get(j - increment);
                if (_comparator.compare(value, previousValue) >= 0) {
                    break;
                }
                list.set(j, previousValue);
            }
            list.set(j, value);
        }
    }
}