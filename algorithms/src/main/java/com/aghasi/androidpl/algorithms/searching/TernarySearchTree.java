package com.aghasi.androidpl.algorithms.searching;

import java.util.List;

public class TernarySearchTree {

    public static final char WILDCARD = '?';
    private TernarySearchTreeNode _root;


    public void add(CharSequence word) {
        assert word.length() > 0 : "word can't be empty";
        TernarySearchTreeNode node = insert(_root, word, 0);
        if (_root == null) {
            _root = node;
        }
    }


    public boolean contains(CharSequence word) {
        assert word.length() > 0 : "word can't be empty";
        TernarySearchTreeNode node = search(_root, word, 0);
        return node != null && node.isEndOfWord();
    }


    public void patternMatch(CharSequence pattern, List results) {
        assert pattern.length() > 0 : "pattern can't be empty";
        patternMatch(_root, pattern, 0, results);
    }


    public void prefixSearch(CharSequence prefix, List results) {
        assert prefix.length() > 0 : "prefix can't be empty";
        inOrderTraversal(search(_root, prefix, 0), results);
    }


    private TernarySearchTreeNode search(TernarySearchTreeNode currentNode, CharSequence word, int index) {
        TernarySearchTreeNode result = currentNode;
        if (currentNode == null) {
            return null;
        }
        char wantedLetter = word.charAt(index);
        if (wantedLetter == currentNode.getChar()) {
            if (index + 1 < word.length()) {
                result = search(currentNode.getChild(), word, index + 1);
            }
        } else if (wantedLetter < currentNode.getChar()) {
            result = search(currentNode.getSmaller(), word, index);
        } else {
            result = search(currentNode.getLarger(), word, index);
        }
        return result;
    }


    private TernarySearchTreeNode insert(TernarySearchTreeNode currentNode, CharSequence word, int index) {

        char wantedLetter = word.charAt(index);
        if (currentNode == null) {
            return insert(new TernarySearchTreeNode(wantedLetter), word, index);
        }
        if (wantedLetter == currentNode.getChar()) {
            if (index + 1 < word.length()) {
                currentNode.setChild(insert(currentNode.getChild(), word, index + 1));
            } else {
                currentNode.setWord(word.toString());
            }
        } else if (wantedLetter < currentNode.getChar()) {
            currentNode.setSmaller(insert(currentNode.getSmaller(), word, index));
        } else {
            currentNode.setLarger(insert(currentNode.getLarger(), word, index));
        }
        return currentNode;
    }


    private void patternMatch(TernarySearchTreeNode currentNode, CharSequence pattern, int index, List results) {
        if (currentNode == null) {
            return;
        }
        char wantedLetter = pattern.charAt(index);
        if (wantedLetter == WILDCARD || wantedLetter < currentNode.getChar()) {
            patternMatch(currentNode.getSmaller(), pattern, index, results);
        }
        if (wantedLetter == WILDCARD || wantedLetter == currentNode.getChar()) {
            if (index + 1 < pattern.length()) {
                patternMatch(currentNode.getChild(), pattern, index + 1, results);
            } else if (currentNode.isEndOfWord()) {
                results.add(currentNode.getWord());
            }
        }
        if (wantedLetter == WILDCARD || wantedLetter > currentNode.getChar()) {
            patternMatch(currentNode.getLarger(), pattern, index, results);
        }
    }


    private void inOrderTraversal(TernarySearchTreeNode currentNode, List results) {
        if (currentNode == null) {
            return;
        }
        inOrderTraversal(currentNode.getSmaller(), results);
        if (currentNode.isEndOfWord()) {
            results.add(currentNode.getWord());
        }
        inOrderTraversal(currentNode.getChild(), results);
        inOrderTraversal(currentNode.getLarger(), results);
    }

}
