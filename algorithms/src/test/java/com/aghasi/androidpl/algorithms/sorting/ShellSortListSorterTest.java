package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;

public class ShellSortListSorterTest extends ListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new ShellSortListSorter(comparator);
    }
}
