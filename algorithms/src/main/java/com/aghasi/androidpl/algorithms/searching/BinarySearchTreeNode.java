package com.aghasi.androidpl.algorithms.searching;


public class BinarySearchTreeNode implements Cloneable {

    private Object _value;
    private BinarySearchTreeNode _parent;
    private BinarySearchTreeNode _smaller;
    private BinarySearchTreeNode _larger;


    public BinarySearchTreeNode(Object value) {
        this(value, null, null);
    }


    public BinarySearchTreeNode(Object value, BinarySearchTreeNode smaller, BinarySearchTreeNode larger) {
        setValue(value);
        setSmaller(smaller);
        setLarger(larger);

        if (smaller != null) {
            smaller.setParent(this);
        }

        if (larger != null) {
            larger.setParent(this);
        }
    }


    public Object getValue() {
        return _value;
    }


    public void setValue(Object value) {
        _value = value;
    }

    public BinarySearchTreeNode getParent() {
        return _parent;
    }


    public void setParent(BinarySearchTreeNode parent) {
        _parent = parent;
    }


    public BinarySearchTreeNode getSmaller() {
        return _smaller;
    }


    public void setSmaller(BinarySearchTreeNode smaller) {
        _smaller = smaller;
    }


    public BinarySearchTreeNode getLarger() {
        return _larger;
    }



    public void setLarger(BinarySearchTreeNode larger) {
        _larger = larger;
    }


    public boolean isSmaller() {
        return getParent() != null && this == getParent().getSmaller();
    }


    public boolean isLarger() {
        return getParent() != null && this == getParent().getLarger();
    }


    public BinarySearchTreeNode minimum() {
        BinarySearchTreeNode node = this;

        while (node.getSmaller() != null) {
            node = node.getSmaller();
        }

        return node;
    }


    public BinarySearchTreeNode maximum() {
        BinarySearchTreeNode node = this;

        while (node.getLarger() != null) {
            node = node.getLarger();
        }

        return node;
    }


    public BinarySearchTreeNode successor() {
        if (getLarger() != null) {
            return getLarger().minimum();
        }

        BinarySearchTreeNode node = this;

        while (node.isLarger()) {
            node = node.getParent();
        }

        return node.getParent();
    }


    public BinarySearchTreeNode predecessor() {
        if (getSmaller() != null) {
            return getSmaller().maximum();
        }

        BinarySearchTreeNode node = this;

        while (node.isSmaller()) {
            node = node.getParent();
        }

        return node.getParent();
    }


    public int size() {
        return size(this);
    }


    public int height() {
        return height(this) - 1;
    }

    public int hashCode() {
        return hashCode(this);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        BinarySearchTreeNode other = (BinarySearchTreeNode) object;

        return getValue().equals(other.getValue())
                && equalsSmaller(other.getSmaller())
                && equalsLarger(other.getLarger());
    }

    public String toString() {
        return getValue().toString();
    }

    public Object clone() {

        BinarySearchTreeNode clone = new BinarySearchTreeNode(getValue());

        if (getSmaller() != null) {
            clone.setSmaller((BinarySearchTreeNode) getSmaller().clone());
        }

        if (getLarger() != null) {
            clone.setLarger((BinarySearchTreeNode) getLarger().clone());
        }

        return clone;
    }


    private int size(BinarySearchTreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + size(node.getSmaller()) + size(node.getLarger());
    }


    private int height(BinarySearchTreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.getSmaller()), height(node.getLarger()));
    }


    private int hashCode(BinarySearchTreeNode node) {
        if (node == null) {
            return 0;
        }

        return getValue().hashCode() ^ hashCode(node.getSmaller()) ^ hashCode(node.getLarger());
    }


    private boolean equalsSmaller(BinarySearchTreeNode other) {
        return getSmaller() == null && other == null || getSmaller() != null && getSmaller().equals(other);
    }


    private boolean equalsLarger(BinarySearchTreeNode other) {
        return getLarger() == null && other == null || getLarger() != null && getLarger().equals(other);
    }
}
