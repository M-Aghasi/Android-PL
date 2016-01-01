package com.aghasi.androidpl.algorithms.searching;

import junit.framework.TestCase;

public class BinarySearchTreeNodeTest extends TestCase {

    private BinarySearchTreeNode _a;
    private BinarySearchTreeNode _d;
    private BinarySearchTreeNode _f;
    private BinarySearchTreeNode _h;
    private BinarySearchTreeNode _i;
    private BinarySearchTreeNode _k;
    private BinarySearchTreeNode _l;
    private BinarySearchTreeNode _m;
    private BinarySearchTreeNode _p;

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
    }

    public void testHashCode() {

        assertFalse(_a.hashCode() == 0);
        assertFalse(_h.hashCode() == 0);
        assertFalse(_i.hashCode() == 0);
        assertFalse(_k.hashCode() == 0);
        assertFalse(_p.hashCode() == 0);
    }

    public void testToString() {

        assertEquals(_a.toString(), _a.getValue().toString());
        assertEquals(_d.toString(), _d.getValue().toString());
        assertEquals(_f.toString(), _f.getValue().toString());
        assertEquals(_h.toString(), _h.getValue().toString());
        assertEquals(_i.toString(), _i.getValue().toString());
        assertEquals(_k.toString(), _k.getValue().toString());
        assertEquals(_l.toString(), _l.getValue().toString());
        assertEquals(_m.toString(), _m.getValue().toString());
        assertEquals(_p.toString(), _p.getValue().toString());
    }

    public void testClone() {

        assertEquals(_a, _a.clone());
        assertEquals(_d, _d.clone());
        assertEquals(_f, _f.clone());
        assertEquals(_h, _h.clone());
        assertEquals(_i, _i.clone());
        assertEquals(_k, _k.clone());
        assertEquals(_l, _l.clone());
        assertEquals(_m, _m.clone());
        assertEquals(_p, _p.clone());
    }

    public void testMinimum() {
        assertSame(_a, _a.minimum());
        assertSame(_a, _d.minimum());
        assertSame(_f, _f.minimum());
        assertSame(_h, _h.minimum());
        assertSame(_a, _i.minimum());
        assertSame(_k, _k.minimum());
        assertSame(_k, _l.minimum());
        assertSame(_m, _m.minimum());
        assertSame(_p, _p.minimum());
    }

    public void testMaximum() {
        assertSame(_a, _a.maximum());
        assertSame(_h, _d.maximum());
        assertSame(_h, _f.maximum());
        assertSame(_h, _h.maximum());
        assertSame(_p, _i.maximum());
        assertSame(_k, _k.maximum());
        assertSame(_p, _l.maximum());
        assertSame(_p, _m.maximum());
        assertSame(_p, _p.maximum());
    }

    public void testSuccessor() {
        assertSame(_d, _a.successor());
        assertSame(_f, _d.successor());
        assertSame(_h, _f.successor());
        assertSame(_i, _h.successor());
        assertSame(_k, _i.successor());
        assertSame(_l, _k.successor());
        assertSame(_m, _l.successor());
        assertSame(_p, _m.successor());
        assertNull(_p.successor());
    }

    public void testPredecessor() {
        assertNull(_a.predecessor());
        assertSame(_a, _d.predecessor());
        assertSame(_d, _f.predecessor());
        assertSame(_f, _h.predecessor());
        assertSame(_h, _i.predecessor());
        assertSame(_i, _k.predecessor());
        assertSame(_k, _l.predecessor());
        assertSame(_l, _m.predecessor());
        assertSame(_m, _p.predecessor());
    }

    public void testIsSmaller() {
        assertTrue(_a.isSmaller());
        assertTrue(_d.isSmaller());
        assertFalse(_f.isSmaller());
        assertFalse(_h.isSmaller());
        assertFalse(_i.isSmaller());
        assertTrue(_k.isSmaller());
        assertFalse(_l.isSmaller());
        assertFalse(_m.isSmaller());
        assertFalse(_p.isSmaller());
    }

    public void testIsLarger() {
        assertFalse(_a.isLarger());
        assertFalse(_d.isLarger());
        assertTrue(_f.isLarger());
        assertTrue(_h.isLarger());
        assertFalse(_i.isLarger());
        assertFalse(_k.isLarger());
        assertTrue(_l.isLarger());
        assertTrue(_m.isLarger());
        assertTrue(_p.isLarger());
    }

    public void testSize() {
        assertEquals(1, _a.size());
        assertEquals(4, _d.size());
        assertEquals(2, _f.size());
        assertEquals(1, _h.size());
        assertEquals(9, _i.size());
        assertEquals(1, _k.size());
        assertEquals(4, _l.size());
        assertEquals(2, _m.size());
        assertEquals(1, _p.size());
    }

    public void testHeight() {
        assertEquals(0, _a.height());
        assertEquals(2, _d.height());
        assertEquals(1, _f.height());
        assertEquals(0, _h.height());
        assertEquals(3, _i.height());
        assertEquals(0, _k.height());
        assertEquals(2, _l.height());
        assertEquals(1, _m.height());
        assertEquals(0, _p.height());
    }

    public void testEquals() {
        BinarySearchTreeNode a = new BinarySearchTreeNode("A");
        BinarySearchTreeNode h = new BinarySearchTreeNode("H");
        BinarySearchTreeNode k = new BinarySearchTreeNode("K");
        BinarySearchTreeNode p = new BinarySearchTreeNode("P");
        BinarySearchTreeNode f = new BinarySearchTreeNode("F", null, h);
        BinarySearchTreeNode m = new BinarySearchTreeNode("M", null, p);
        BinarySearchTreeNode d = new BinarySearchTreeNode("D", a, f);
        BinarySearchTreeNode l = new BinarySearchTreeNode("L", k, m);
        BinarySearchTreeNode i = new BinarySearchTreeNode("I", d, l);

        assertEquals(a, _a);
        assertEquals(d, _d);
        assertEquals(f, _f);
        assertEquals(h, _h);
        assertEquals(i, _i);
        assertEquals(k, _k);
        assertEquals(l, _l);
        assertEquals(m, _m);
        assertEquals(p, _p);

        assertFalse(_i.equals(null));
        assertFalse(_f.equals(_d));
    }
}