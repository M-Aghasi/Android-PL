package com.aghasi.androidpl.algorithms.sorting;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BinaryInsertionSortListSorter implements ListSorter {

    private final Comparator _comparator;


    public BinaryInsertionSortListSorter(Comparator comparator) {

        _comparator = comparator;
    }


    public List sort(List listToSort) {

        final List sortedList = new LinkedList<>();

        sort(listToSort, sortedList);

        return sortedList;
    }

    void sort(List listToSort, final List sortedList) {

        for (Object currentItemToInsert : listToSort) {
            int insertionIndex = Arrays.binarySearch(sortedList.toArray(), currentItemToInsert, _comparator);
            if(insertionIndex < 0) {
                insertionIndex = (-insertionIndex)-1;
            }
            sortedList.add(insertionIndex, currentItemToInsert);
        }
    }
}
