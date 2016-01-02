# Algorithms
this module consists of some common algorithms for sorting, searching, word matching ... and data structures like trees
for solving various problems gracefully!

I tried to avoid redundancy, and only added algorithms and data structures which doesn't exist in Java and android standard libraries(i hope!).

> *this module has lot of codes and ideas from the * [Beginning Algorithms](http://www.wrox.com/WileyCDA/WroxTitle/Beginning-Algorithms.productCd-0764596748.html) *book.*

## Packages
list of algorithms module packages
* ### comparators
    this package consists of multiple comparator classes which used for comparing two objects and returning appropriate result
    comparators are useful in areas like sorting, Tree data structures and so on.
    * ##### NaturalComparator
        compares two object in natural way
    * ##### CompoundComparator
        examines multiple comparators in order on equation of objects
    * ##### CallCountingComparator
        special comparator which wraps another comparator and counts call to that comparator,
        very useful for test and comparison between algorithms
    * ##### FixedComparator
        special comparator which always return same result, useful for testing purposes.
* ### searching
    this package consists of a variation of Tree data structures and different algorithms for searching an item in a bunch of items
    * ##### BinarySearchTree
    * ##### BinarySearchTreeNode
    * ##### TernarySearchTree
    * ##### TernarySearchTreeNode
    * ##### BTreeMap
        ToDo: currently stores nodes in main memory, should add capability to store them on secondary storage like HDD.
        ToDo: currently delete method doesn't remove items, just flag items as deleted, so lot of memory vasts.   
* ### sorting
    this package consists of a ListSorter interface and multiple sorting algorithm classes which implement this interface.
    * ##### ListSorter
        Interface for ListSorter implementations
    * ##### BinaryInsertionSortListSorter
    * ##### BubbleSortListSorter
    * ##### InsertionSortListSorter
    * ##### MergeSortListSorter
    * ##### QuickSortListSorter
    * ##### SelectionSortListSorter
    * ##### ShellSortListSorter
* ### wordMatching
    this package holds multiple algorithms for comparing two string if they are similar in phonetic or other way.
    * ##### LevenshteinWordDistanceCalculator
    * ##### PhoneticEncoder
      Interface for PhoneticEncoder implementations
    * ##### SoundexPhoneticEncoder
