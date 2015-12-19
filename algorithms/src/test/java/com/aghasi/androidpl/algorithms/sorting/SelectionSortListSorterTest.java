package com.aghasi.androidpl.algorithms.sorting;

import java.util.Comparator;



public class SelectionSortListSorterTest extends ListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new SelectionSortListSorter(comparator);
    }
}