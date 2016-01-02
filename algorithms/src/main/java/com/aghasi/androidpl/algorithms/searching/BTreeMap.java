package com.aghasi.androidpl.algorithms.searching;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BTreeMap {

    private static final int MIN_KEYS_PER_NODE = 2;

    private final Comparator _comparator;
    private final int _maxKeysPerNode;
    private Node _root;
    private int _size;


    public BTreeMap(Comparator comparator, int maxKeysPerNode) {
        assert maxKeysPerNode >= MIN_KEYS_PER_NODE : "maxKeysPerNode can't be < " + MIN_KEYS_PER_NODE;
        _comparator = comparator;
        _maxKeysPerNode = maxKeysPerNode;
        clear();
    }


    public Object get(Object key) {
        Entry entry = _root.search(key);
        return entry != null ? entry.getValue() : null;
    }


    public Object set(Object key, Object value) {
        Object oldValue = _root.set(key, value);
        if (_root.isFull()) {
            Node newRoot = new Node(false);
            _root.split(newRoot, 0);
            _root = newRoot;
        }
        return oldValue;
    }


    public Object delete(Object key) {
        Entry entry = _root.search(key);
        if (entry == null) {
            return null;
        }
        entry.setDeleted(true);
        --_size;
        return entry.setValue(null);
    }


    public boolean contains(Object key) {
        return _root.search(key) != null;
    }


    public void clear() {
        _root = new Node(true);
        _size = 0;
    }


    public int size() {
        return _size;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public Iterator iterator() {
        List list = new ArrayList<>(_size);
        _root.traverse(list);
        return list.iterator();
    }


    private final class Node {
        private final List _entries = new ArrayList(_maxKeysPerNode + 1);
        private final List _children;


        public Node(boolean leaf) {
            _children = (!leaf ? new ArrayList(_maxKeysPerNode + 2) : Collections.EMPTY_LIST);
        }


        public boolean isFull() {
            return _entries.size() > _maxKeysPerNode;
        }


        public Entry search(Object key) {
            int index = indexOf(key);
            if (index >= 0) {
                Entry entry = (Entry) _entries.get(index);
                return !entry.isDeleted() ? entry : null;
            }
            return (!isLeaf() ? ((Node) _children.get(-(index + 1))).search(key) : null);
        }


        public Object set(Object key, Object value) {
            int index = indexOf(key);
            if (index >= 0) {
                return ((Entry) _entries.get(index)).setValue(value);
            }

            return set(key, value, -(index + 1));
        }


        private Object set(Object key, Object value, int index) {
            if (isLeaf()) {
                _entries.add(index, new Entry(key, value));
                ++_size;
                return null;
            }
            Node child = ((Node) _children.get(index));
            Object oldValue = child.set(key, value);
            if (child.isFull()) {
                child.split(this, index);
            }
            return oldValue;
        }


        private int indexOf(Object key) {
            int lowerIndex = 0;
            int upperIndex = _entries.size() - 1;
            while (lowerIndex <= upperIndex) {
                int index = lowerIndex + (upperIndex - lowerIndex) / 2;
                int cmp = _comparator.compare(key, ((Entry) _entries.get(index)).getKey());
                if (cmp == 0) {
                    return index;
                } else if (cmp < 0) {
                    upperIndex = index - 1;
                } else {
                    lowerIndex = index + 1;
                }
            }
            return -(lowerIndex + 1);
        }


        public void split(Node parent, int insertionPoint) {
            Node sibling = new Node(isLeaf());
            int middle = _entries.size() / 2;
            move(_entries, middle + 1, sibling._entries);
            move(_children, middle + 1, sibling._children);
            parent._entries.add(insertionPoint, _entries.remove(middle));
            if (parent._children.isEmpty()) {
                parent._children.add(insertionPoint, this);
            }
            parent._children.add(insertionPoint + 1, sibling);
        }


        public void traverse(List list) {
            Iterator children = _children.iterator();
            Iterator entries = _entries.iterator();
            while (children.hasNext() || entries.hasNext()) {
                if (children.hasNext()) {
                    ((Node) children.next()).traverse(list);
                }
                if (entries.hasNext()) {
                    Entry entry = (Entry) entries.next();
                    if (!entry.isDeleted()) {
                        list.add(entry);
                    }
                }
            }
        }


        private void move(List source, int from, List target) {
            while (from < source.size()) {
                target.add(source.remove(from));
            }
        }


        private boolean isLeaf() {
            return _children == Collections.EMPTY_LIST;
        }
    }


    private static final class Entry extends DefaultMapEntry {
        private boolean _deleted;

        public Entry(Object key, Object value) {
            super(key, value);
        }

        public boolean isDeleted() {
            return _deleted;
        }

        public void setDeleted(boolean deleted) {
            _deleted = deleted;
        }
    }
}
