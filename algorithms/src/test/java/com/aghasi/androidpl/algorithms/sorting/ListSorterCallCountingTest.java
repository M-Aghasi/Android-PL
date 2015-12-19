package com.aghasi.androidpl.algorithms.sorting;


import com.aghasi.androidpl.algorithms.CallCountingComparator;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 public class ListSorterCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private final List _sortedArrayList = new ArrayList<>(TEST_SIZE);
    private final List _reverseArrayList = new ArrayList(TEST_SIZE);
    private final List _randomArrayList = new ArrayList(TEST_SIZE);

    private CallCountingComparator _comparator;

    protected void setUp() throws Exception {

        super.setUp();
        _comparator = new CallCountingComparator(Comparator.<Integer>naturalOrder());

        fillSortedList();
        fillReverseList();
        fillRandomList();
    }

     private void fillSortedList() {

         for (int i = 1; i < TEST_SIZE; ++i) {
             _sortedArrayList.add(i);
         }
     }


     private void fillReverseList() {

         for (int i = TEST_SIZE; i > 0; --i) {
             _reverseArrayList.add(i);
         }
     }

     private void fillRandomList() {

         for (int i = 1; i < TEST_SIZE; ++i) {
             _randomArrayList.add((int)(TEST_SIZE * Math.random()));
         }
     }

    public void testWorstCaseBubblesort() {
        new BubbleSortListSorter(_comparator).sort(_reverseArrayList);
        printComparatorCallsReport();
    }

    public void testWorstCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_reverseArrayList);
        printComparatorCallsReport();
    }

    public void testWorstCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_reverseArrayList);
        printComparatorCallsReport();
    }

//    public void testWorstCaseShellsort() {
//        new ShellsortListSorter(_comparator).sort(_reverseArrayList);
//        reportCalls();
//    }
//
//    public void testWorstCaseQuicksort() {
//        new QuicksortListSorter(_comparator).sort(_reverseArrayList);
//        reportCalls();
//    }
//
//    public void testWorstCaseMergesort() {
//        new MergesortListSorter(_comparator).sort(_reverseArrayList);
//        reportCalls();
//    }

    public void testBestCaseBubblesort() {
        new BubbleSortListSorter(_comparator).sort(_sortedArrayList);
        printComparatorCallsReport();
    }

    public void testBestCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_sortedArrayList);
        printComparatorCallsReport();
    }

    public void testBestCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_sortedArrayList);
        printComparatorCallsReport();
    }

//    public void testBestCaseShellsort() {
//        new ShellsortListSorter(_comparator).sort(_sortedArrayList);
//        reportCalls();
//    }
//
//    public void testBestCaseQuicksort() {
//        new QuicksortListSorter(_comparator).sort(_sortedArrayList);
//        reportCalls();
//    }
//
//    public void testBestCaseMergesort() {
//        new MergesortListSorter(_comparator).sort(_sortedArrayList);
//        reportCalls();
//    }

    public void testAverageCaseBubblesort() {
        new BubbleSortListSorter(_comparator).sort(_randomArrayList);
        printComparatorCallsReport();
    }

    public void testAverageCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_randomArrayList);
        printComparatorCallsReport();
    }

    public void testAverageCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_randomArrayList);
        printComparatorCallsReport();
    }

//    public void testAverageCaseShellsort() {
//        new ShellsortListSorter(_comparator).sort(_randomArrayList);
//        reportCalls();
//    }
//
//    public void testAverageCaseQuicksort() {
//        new QuicksortListSorter(_comparator).sort(_randomArrayList);
//        reportCalls();
//    }
//
//    public void testAverageCaseMergeSort() {
//        new MergesortListSorter(_comparator).sort(_randomArrayList);
//        reportCalls();
//    }

    private void printComparatorCallsReport() {
        System.out.println(getName() + ": " + _comparator.getCallCount() + " calls");
    }
}

