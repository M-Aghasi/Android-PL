package com.aghasi.androidpl.algorithms.sorting;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeSortListSorter implements ListSorter {

    private final Comparator _comparator;


    public MergeSortListSorter(Comparator comparator) {
        _comparator = comparator;
    }


    public List sort(List list) {

        return mergeSortList(list, 0, list.size() - 1);
    }


    private List mergeSortList(List list, int startIndex, int endIndex) {
        if (isBaseCase(startIndex, endIndex)) {
            List result = new ArrayList();
            result.add(list.get(startIndex));
            return result;
        }
        return divideListAndMergeSubLists(list, startIndex, endIndex);
    }

    private boolean isBaseCase(int startIndex, int endIndex) {

        return startIndex == endIndex;
    }

    private List divideListAndMergeSubLists(List list, int startIndex, int endIndex) {

        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        List left = mergeSortList(list, startIndex, splitIndex);
        List right = mergeSortList(list, splitIndex + 1, endIndex);
        return mergeSubLists(left, right);
    }


    private List mergeSubLists(List left, List right) {

        List result = new ArrayList();
        Iterator l = left.iterator();
        Iterator r = right.iterator();
        Object currentLeft = getNextOrNull(l);
        Object currentRight = getNextOrNull(r);
        while (currentLeft != null || currentRight != null) {
            if (currentLeft == null) {
                result.add(currentRight);
                currentRight = getNextOrNull(r);
            } else if (currentRight == null) {
                result.add(currentLeft);
                currentLeft = getNextOrNull(l);
            } else if (_comparator.compare(currentLeft, currentRight) <= 0) {
                result.add(currentLeft);
                currentLeft = getNextOrNull(l);
            } else {
                result.add(currentRight);
                currentRight = getNextOrNull(r);
            }
        }
        return result;
    }


    private Object getNextOrNull(Iterator i) {

        if(i.hasNext()) {
            return i.next();
        }
        else {
            return null;
        }
    }
}
