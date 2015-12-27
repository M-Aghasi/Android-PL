package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;

public class MergeSortListSorterTest extends ListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new MergeSortListSorter(comparator);
    }
}