package com.aghasi.androidpl.algorithms.searching;


import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class TernarySearchTreeTest extends TestCase {

    private TernarySearchTree _tree;

    protected void setUp() throws Exception {
        super.setUp();

        _tree = new TernarySearchTree();

        _tree.add("prefabricate");
        _tree.add("presume");
        _tree.add("prejudice");
        _tree.add("preliminary");
        _tree.add("apple");
        _tree.add("ape");
        _tree.add("appeal");
        _tree.add("car");
        _tree.add("dog");
        _tree.add("cat");
        _tree.add("mouse");
        _tree.add("mince");
        _tree.add("minty");
    }

    public void testContains() {
        assertTrue(_tree.contains("prefabricate"));
        assertTrue(_tree.contains("presume"));
        assertTrue(_tree.contains("prejudice"));
        assertTrue(_tree.contains("preliminary"));
        assertTrue(_tree.contains("apple"));
        assertTrue(_tree.contains("ape"));
        assertTrue(_tree.contains("appeal"));
        assertTrue(_tree.contains("car"));
        assertTrue(_tree.contains("dog"));
        assertTrue(_tree.contains("cat"));
        assertTrue(_tree.contains("mouse"));
        assertTrue(_tree.contains("mince"));
        assertTrue(_tree.contains("minty"));

        assertFalse(_tree.contains("pre"));
        assertFalse(_tree.contains("dogs"));
        assertFalse(_tree.contains("UNKNOWN"));
    }

    public void testPrefixSearch() {
        assertPrefixResultEqualsToArray(new String[]{"prefabricate", "prejudice", "preliminary", "presume"}, "pre");
        assertPrefixResultEqualsToArray(new String[] {"ape", "appeal", "apple"}, "ap");
    }

    public void testPatternMatch() {
        assertPatternResultEqualsToArray(new String[]{"mince", "mouse"}, "m???e");
        assertPatternResultEqualsToArray(new String[]{"car", "cat"}, "?a?");
    }

    public void testSearchWithCommonSuffix() {

        TernarySearchTree tree = new TernarySearchTree();
        tree.add("man");
        tree.add("hitman");

        assertTrue(tree.contains("man"));
        assertTrue(tree.contains("hitman"));
        assertFalse(tree.contains("an"));
    }

    private void assertPrefixResultEqualsToArray(String[] expected, String prefix) {
        List words = new LinkedList<>();

        _tree.prefixSearch(prefix, words);

        assertArrayEqualsToList(expected, words);
    }

    private void assertPatternResultEqualsToArray(String[] expected, String pattern) {
        List words = new LinkedList();

        _tree.patternMatch(pattern, words);

        assertArrayEqualsToList(expected, words);
    }

    private void assertArrayEqualsToList(String[] expected, List actual) {
        assertEquals(expected.length, actual.size());

        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }
}
