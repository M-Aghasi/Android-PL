package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;
import java.util.List;

public class SelectionSortListSorter implements ListSorter {
    private final Comparator _comparator;


    public SelectionSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }


    public List sort(List list) {

        int listSize = list.size();

        for (int indexToInsertCurrentSmallest = 0; indexToInsertCurrentSmallest < listSize - 1; ++indexToInsertCurrentSmallest) {
            int currentSmallest = indexToInsertCurrentSmallest;
            for (int indexToCompare = indexToInsertCurrentSmallest + 1; indexToCompare < listSize; ++indexToCompare) {
                if (_comparator.compare(list.get(indexToCompare), list.get(currentSmallest)) < 0) {
                    currentSmallest = indexToCompare;
                }
            }
            swapItems(list, currentSmallest, indexToInsertCurrentSmallest);
        }
        return list;
    }


    private void swapItems(List list, int firstItem, int secondItem) {
        if (firstItem == secondItem) {
            return;
        }
        Object temp = list.get(firstItem);
        list.set(firstItem, list.get(secondItem));
        list.set(secondItem, temp);
    }
}
