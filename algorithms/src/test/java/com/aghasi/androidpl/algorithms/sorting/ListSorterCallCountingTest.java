package com.aghasi.androidpl.algorithms.sorting;


import com.aghasi.androidpl.algorithms.comparators.CallCountingComparator;
import com.aghasi.androidpl.algorithms.comparators.NaturalComparator;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

 public class ListSorterCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private final List _sortedArrayList = new ArrayList<>(TEST_SIZE);
    private final List _reverseArrayList = new ArrayList(TEST_SIZE);
    private final List _randomArrayList = new ArrayList(TEST_SIZE);

    private CallCountingComparator _comparator;

    protected void setUp() throws Exception {

        super.setUp();
        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);

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

     public void testWorstCaseBinaryInsertionSort() {
         new BinaryInsertionSortListSorter(_comparator).sort(_reverseArrayList);
         printComparatorCallsReport();
     }

    public void testWorstCaseShellsort() {
        new ShellSortListSorter(_comparator).sort(_reverseArrayList);
        printComparatorCallsReport();
    }

    public void testWorstCaseQuicksort() {
        new QuickSortListSorter(_comparator).sort(_reverseArrayList);
        printComparatorCallsReport();
    }

    public void testWorstCaseMergesort() {
        new MergeSortListSorter(_comparator).sort(_reverseArrayList);
        printComparatorCallsReport();
    }

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

     public void testBestCaseBinaryInsertionSort() {
         new BinaryInsertionSortListSorter(_comparator).sort(_sortedArrayList);
         printComparatorCallsReport();
     }

    public void testBestCaseShellsort() {
        new ShellSortListSorter(_comparator).sort(_sortedArrayList);
        printComparatorCallsReport();
    }

    public void testBestCaseQuicksort() {
        new QuickSortListSorter(_comparator).sort(_sortedArrayList);
        printComparatorCallsReport();
    }

    public void testBestCaseMergesort() {
        new MergeSortListSorter(_comparator).sort(_sortedArrayList);
        printComparatorCallsReport();
    }

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

     public void testAverageCaseBinaryInsertionSort() {
         new BinaryInsertionSortListSorter(_comparator).sort(_randomArrayList);
         printComparatorCallsReport();
     }

    public void testAverageCaseShellsort() {
        new ShellSortListSorter(_comparator).sort(_randomArrayList);
        printComparatorCallsReport();
    }

    public void testAverageCaseQuicksort() {
        new QuickSortListSorter(_comparator).sort(_randomArrayList);
        printComparatorCallsReport();
    }

    public void testAverageCaseMergeSort() {
        new MergeSortListSorter(_comparator).sort(_randomArrayList);
        printComparatorCallsReport();
    }

    private void printComparatorCallsReport() {
        System.out.println(getName() + ": " + _comparator.getCallCount() + " calls");
    }
}

