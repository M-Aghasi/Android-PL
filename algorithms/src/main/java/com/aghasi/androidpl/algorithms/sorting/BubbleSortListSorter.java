package com.aghasi.androidpl.algorithms.sorting;

import java.util.Comparator;
import java.util.List;

public class BubbleSortListSorter implements ListSorter {
    private final Comparator _comparator;


    public BubbleSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }


    public List sort(List list) {

        int listSize = list.size();

        for (int pass = 1; pass < listSize; ++pass) {
            for (int currentItem = 0; currentItem < (listSize - pass); ++currentItem) {
                int rightOfCurrentItem = currentItem + 1;
                if (_comparator.compare(list.get(currentItem), list.get(rightOfCurrentItem)) > 0) {
                    swapItems(list, currentItem, rightOfCurrentItem);
                }
            }
        }

        return list;
    }

    private void swapItems(List list, int firstItem, int secondItem) {
        Object firstItemTemp = list.get(firstItem);
        list.set(firstItem, list.get(secondItem));
        list.set(secondItem, firstItemTemp);
    }
}
