package com.aghasi.androidpl.algorithms.sorting;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertionSortListSorter implements ListSorter {
    private final Comparator _comparator;


    public InsertionSortListSorter(Comparator comparator) {

        _comparator = comparator;
    }


    public List sort(List listToSort) {

        final List sortedList = new LinkedList<>();

        sort(listToSort, sortedList);

        return sortedList;
    }

    void sort(List listToSort, final List sortedList) {

        for (Object currentItemToInsert : listToSort) {
            int insertionIndex = sortedList.size();
            while (insertionIndex > 0) {
                if (_comparator.compare(currentItemToInsert, sortedList.get(insertionIndex - 1)) >= 0) {
                    break;
                }
                --insertionIndex;
            }
            sortedList.add(insertionIndex, currentItemToInsert);
        }
    }
}
