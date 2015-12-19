package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;

public class InsertionSortListSorterTest extends ListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new InsertionSortListSorter(comparator);
    }
}