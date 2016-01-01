package com.aghasi.androidpl.algorithms.searching;


import java.util.Comparator;

public class BinarySearchTree {

    private final Comparator _comparator;
    private BinarySearchTreeNode _root;


    public BinarySearchTree(Comparator comparator) {
        _comparator = comparator;
    }


    public BinarySearchTreeNode search(Object value) {

        BinarySearchTreeNode node = _root;
        while (node != null) {
            int cmp = _comparator.compare(value, node.getValue());
            if (cmp == 0) {
                break;
            }
            node = cmp < 0 ? node.getSmaller() : node.getLarger();
        }
        return node;
    }


    public BinarySearchTreeNode insert(Object value) {

        BinarySearchTreeNode insertNodeParent = null;
        BinarySearchTreeNode node = _root;
        int cmp = 0;
        while (node != null) {
            insertNodeParent = node;
            cmp = _comparator.compare(value, node.getValue());
            node = cmp <= 0 ? node.getSmaller() : node.getLarger();
        }
        BinarySearchTreeNode insertedNode = new BinarySearchTreeNode(value);
        insertedNode.setParent(insertNodeParent);

        if (insertNodeParent == null) {
            _root = insertedNode;
        } else if (cmp < 0) {
            insertNodeParent.setSmaller(insertedNode);
        } else {
            insertNodeParent.setLarger(insertedNode);
        }
        return insertedNode;
    }


    public BinarySearchTreeNode delete(Object value) {
        BinarySearchTreeNode nodeToDelete = search(value);
        if (nodeToDelete == null) {
            return null;
        }
        BinarySearchTreeNode deleteCandidate = detectDeleteCandidate(nodeToDelete);
        BinarySearchTreeNode replacement = detectReplacement(deleteCandidate);
        swipeDeleteCandidateWithReplacement(deleteCandidate, replacement);
        if (deleteCandidate != nodeToDelete) {
            Object deletedValue = nodeToDelete.getValue();
            nodeToDelete.setValue(deleteCandidate.getValue());
            deleteCandidate.setValue(deletedValue);
        }
        return deleteCandidate;
    }


    private BinarySearchTreeNode detectDeleteCandidate(BinarySearchTreeNode node) {
         return (node.getSmaller() != null && node.getLarger() != null)
                ? node.successor() : node;
    }


    private BinarySearchTreeNode detectReplacement(BinarySearchTreeNode deleteCandidate) {
        return deleteCandidate.getSmaller() != null
                ? deleteCandidate.getSmaller() : deleteCandidate.getLarger();
    }


    private void swipeDeleteCandidateWithReplacement(BinarySearchTreeNode deleteCandidate, BinarySearchTreeNode replacement) {
        if (replacement != null) {
            replacement.setParent(deleteCandidate.getParent());
        }
        if (deleteCandidate == _root) {
            _root = replacement;
        } else if (deleteCandidate.isSmaller()) {
            deleteCandidate.getParent().setSmaller(replacement);
        } else {
            deleteCandidate.getParent().setLarger(replacement);
        }
    }


    public BinarySearchTreeNode getRoot() {
        return _root;
    }
}
