package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;
import java.util.List;

public class QuickSortListSorter implements ListSorter {

    private final Comparator _comparator;


    public QuickSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }


    public List sort(List list) {

        quickSort(list, 0, list.size() - 1);
        return list;
    }

    private void quickSort(List list, int startIndex, int endIndex) {

        if (startIndex < 0 || endIndex >= list.size()) {
            return;
        }
        if (endIndex <= startIndex) {
            return;
        }
        Object value = list.get(endIndex);
        int partition = partition(list, value, startIndex, endIndex - 1);
        if (_comparator.compare(list.get(partition), value) < 0) {
            ++partition;
        }
        swapItems(list, partition, endIndex);
        quickSort(list, startIndex, partition - 1);
        quickSort(list, partition + 1, endIndex);
    }

    private int partition(List list, Object value, int leftIndex, int rightIndex) {

        int left = leftIndex;
        int right = rightIndex;
        while (left < right) {
            if (_comparator.compare(list.get(left), value) < 0) {
                ++left;
                continue;
            }
            if (_comparator.compare(list.get(right), value) >= 0) {
                --right;
                continue;
            }
            swapItems(list, left, right);
            ++left;
        }
        return left;
    }

    private void swapItems(List list, int firstItem, int secondItem) {
        Object firstItemTemp = list.get(firstItem);
        list.set(firstItem, list.get(secondItem));
        list.set(secondItem, firstItemTemp);
    }
}
