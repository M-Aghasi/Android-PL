package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;

public class BinaryInsertionSortListSorterTest extends ListSorterTest {

    protected ListSorter createListSorter(Comparator comparator) {
        return new BinaryInsertionSortListSorter(comparator);
    }
}
