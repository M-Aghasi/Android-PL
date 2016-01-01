package com.aghasi.androidpl.algorithms.searching;

import com.aghasi.androidpl.algorithms.comparators.NaturalComparator;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

    private BinarySearchTreeNode _a;
    private BinarySearchTreeNode _d;
    private BinarySearchTreeNode _f;
    private BinarySearchTreeNode _h;
    private BinarySearchTreeNode _i;
    private BinarySearchTreeNode _k;
    private BinarySearchTreeNode _l;
    private BinarySearchTreeNode _m;
    private BinarySearchTreeNode _p;
    private BinarySearchTreeNode _root;
    private BinarySearchTree _tree;

    protected void setUp() throws Exception {
        super.setUp();

        _a = new BinarySearchTreeNode("A");
        _h = new BinarySearchTreeNode("H");
        _k = new BinarySearchTreeNode("K");
        _p = new BinarySearchTreeNode("P");
        _f = new BinarySearchTreeNode("F", null, _h);
        _m = new BinarySearchTreeNode("M", null, _p);
        _d = new BinarySearchTreeNode("D", _a, _f);
        _l = new BinarySearchTreeNode("L", _k, _m);
        _i = new BinarySearchTreeNode("I", _d, _l);
        _root = _i;

        _tree = new BinarySearchTree(NaturalComparator.INSTANCE);
        _tree.insert(_i.getValue());
        _tree.insert(_d.getValue());
        _tree.insert(_l.getValue());
        _tree.insert(_a.getValue());
        _tree.insert(_f.getValue());
        _tree.insert(_k.getValue());
        _tree.insert(_m.getValue());
        _tree.insert(_h.getValue());
        _tree.insert(_p.getValue());
    }

    public void testInsert() {
        assertEquals(_root, _tree.getRoot());
    }

    public void testSearch() {
        assertEquals(_a, _tree.search(_a.getValue()));
        assertEquals(_d, _tree.search(_d.getValue()));
        assertEquals(_f, _tree.search(_f.getValue()));
        assertEquals(_h, _tree.search(_h.getValue()));
        assertEquals(_i, _tree.search(_i.getValue()));
        assertEquals(_k, _tree.search(_k.getValue()));
        assertEquals(_l, _tree.search(_l.getValue()));
        assertEquals(_m, _tree.search(_m.getValue()));
        assertEquals(_p, _tree.search(_p.getValue()));

        assertNull(_tree.search("UNKNOWN"));
    }

    public void testDeleteLeafNode() {
        BinarySearchTreeNode deleted = _tree.delete(_h.getValue());
        assertNotNull(deleted);
        assertEquals(_h.getValue(), deleted.getValue());

        _f.setLarger(null);
        assertEquals(_root, _tree.getRoot());
    }

    public void testDeleteNodeWithOneChild() {
        BinarySearchTreeNode deleted = _tree.delete(_m.getValue());
        assertNotNull(deleted);
        assertEquals(_m.getValue(), deleted.getValue());

        _l.setLarger(_p);
        assertEquals(_root, _tree.getRoot());
    }

    public void testDeleteNodeWithTwoChildren() {
        BinarySearchTreeNode deleted = _tree.delete(_i.getValue());
        assertNotNull(deleted);
        assertEquals(_i.getValue(), deleted.getValue());

        _i.setValue(_k.getValue());
        _l.setSmaller(null);
        assertEquals(_root, _tree.getRoot());
    }

    public void testDeleteRootNodeUntilTreeIsEmpty() {
        while (_tree.getRoot() != null) {
            Object key = _tree.getRoot().getValue();
            BinarySearchTreeNode deleted = _tree.delete(key);
            assertNotNull(deleted);
            assertEquals(key, deleted.getValue());
        }
    }
}
