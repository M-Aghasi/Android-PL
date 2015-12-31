package com.aghasi.androidpl.algorithms;


import java.util.Arrays;
import java.util.List;

public class ListBinaryInsertor {



    public int insert(List sortedList, Object item) {

        int insertionIndex = Arrays.binarySearch(sortedList.toArray(), item);
        if (insertionIndex < 0) {
            insertionIndex = -(insertionIndex + 1);
        }
        sortedList.add(insertionIndex, item);
        return insertionIndex;
    }
}

