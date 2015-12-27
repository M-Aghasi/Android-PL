package com.aghasi.androidpl.algorithms.sorting;

import com.aghasi.androidpl.algorithms.comparators.NaturalComparator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

  public abstract class ListSorterTest extends junit.framework.TestCase {

    private List _unsortedList;
    private List _sortedList;

    public void setUp() throws Exception {

        super.setUp();
        _unsortedList = new LinkedList<>();
        _sortedList = new LinkedList();

        fillUnsortedList();
        fillSortedList();
    }

      private void fillUnsortedList() {

          _unsortedList.add("test");
          _unsortedList.add("driven");
          _unsortedList.add("development");
          _unsortedList.add("is");
          _unsortedList.add("one");
          _unsortedList.add("small");
          _unsortedList.add("step");
          _unsortedList.add("for");
          _unsortedList.add("a");
          _unsortedList.add("programmer");
          _unsortedList.add("but");
          _unsortedList.add("it's");
          _unsortedList.add("one");
          _unsortedList.add("giant");
          _unsortedList.add("leap");
          _unsortedList.add("for");
          _unsortedList.add("programming");
      }

      private void fillSortedList() {

          _sortedList.add("a");
          _sortedList.add("but");
          _sortedList.add("development");
          _sortedList.add("driven");
          _sortedList.add("for");
          _sortedList.add("for");
          _sortedList.add("giant");
          _sortedList.add("is");
          _sortedList.add("it's");
          _sortedList.add("leap");
          _sortedList.add("one");
          _sortedList.add("one");
          _sortedList.add("programmer");
          _sortedList.add("programming");
          _sortedList.add("small");
          _sortedList.add("step");
          _sortedList.add("test");
      }


    public void tearDown() throws Exception {

        super.tearDown();
        _sortedList = null;
        _unsortedList = null;
    }


    public void testListSorterCanSortSampleList() {
        ListSorter sorter = createListSorter(NaturalComparator.INSTANCE);
        assertEquals(_sortedList, sorter.sort(_unsortedList));
    }

      protected abstract ListSorter createListSorter(Comparator comparator);
}