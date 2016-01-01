package com.aghasi.androidpl.algorithms.searching;

public class TernarySearchTreeNode {

    private final char _char;
    private TernarySearchTreeNode _smaller;
    private TernarySearchTreeNode _larger;
    private TernarySearchTreeNode _child;
    private String _word;

    public TernarySearchTreeNode(char c) {
        _char = c;
    }

    public char getChar() {
        return _char;
    }

    public TernarySearchTreeNode getSmaller() {
        return _smaller;
    }

    public void setSmaller(TernarySearchTreeNode smaller) {
        _smaller = smaller;
    }

    public TernarySearchTreeNode getLarger() {
        return _larger;
    }

    public void setLarger(TernarySearchTreeNode larger) {
        _larger = larger;
    }

    public TernarySearchTreeNode getChild() {
        return _child;
    }

    public void setChild(TernarySearchTreeNode child) {
        _child = child;
    }

    public String getWord() {
        return _word;
    }

    public void setWord(String word) {
        _word = word;
    }

    public boolean isEndOfWord() {
        return getWord() != null;
    }
}
