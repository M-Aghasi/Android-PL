package com.aghasi.androidpl.algorithms.sorting;

import java.util.Comparator;



public class BubbleSortListSorterTest extends ListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new BubbleSortListSorter(comparator);
    }
}