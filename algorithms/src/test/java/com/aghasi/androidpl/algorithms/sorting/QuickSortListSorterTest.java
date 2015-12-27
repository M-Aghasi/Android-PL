package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;

public class QuickSortListSorterTest extends ListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new QuickSortListSorter(comparator);
    }
}
