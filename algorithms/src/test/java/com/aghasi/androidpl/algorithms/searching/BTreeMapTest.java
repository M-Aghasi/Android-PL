package com.aghasi.androidpl.algorithms.searching;


import com.aghasi.androidpl.algorithms.comparators.NaturalComparator;

import junit.framework.TestCase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class BTreeMapTest extends TestCase {


    private static final Map.Entry A = new DefaultMapEntry("akey", "avalue");
    private static final Map.Entry B = new DefaultMapEntry("bkey", "bvalue");
    private static final Map.Entry C = new DefaultMapEntry("ckey", "cvalue");
    private static final Map.Entry D = new DefaultMapEntry("dkey", "dvalue");
    private static final Map.Entry E = new DefaultMapEntry("ekey", "evalue");
    private static final Map.Entry F = new DefaultMapEntry("fkey", "fvalue");

    private BTreeMap _map;


    protected void setUp() throws Exception {
        super.setUp();

        _map = new BTreeMap(NaturalComparator.INSTANCE, 2);

        _map.set(C.getKey(), C.getValue());
        _map.set(A.getKey(), A.getValue());
        _map.set(B.getKey(), B.getValue());
        _map.set(D.getKey(), D.getValue());
    }

    public void testContainsExisting() {
        assertTrue(_map.contains(A.getKey()));
        assertTrue(_map.contains(B.getKey()));
        assertTrue(_map.contains(C.getKey()));
        assertTrue(_map.contains(D.getKey()));
    }

    public void testContainsNonExisting() {
        assertFalse(_map.contains(E.getKey()));
        assertFalse(_map.contains(F.getKey()));
    }

    public void testGetExisting() {
        assertEquals(A.getValue(), _map.get(A.getKey()));
        assertEquals(B.getValue(), _map.get(B.getKey()));
        assertEquals(C.getValue(), _map.get(C.getKey()));
        assertEquals(D.getValue(), _map.get(D.getKey()));
    }

    public void testGetNonExisting() {
        assertNull(_map.get(E.getKey()));
        assertNull(_map.get(F.getKey()));
    }

    public void testSetNewKey() {
        assertEquals(4, _map.size());

        assertNull(_map.set(E.getKey(), E.getValue()));
        assertEquals(E.getValue(), _map.get(E.getKey()));
        assertEquals(5, _map.size());

        assertNull(_map.set(F.getKey(), F.getValue()));
        assertEquals(F.getValue(), _map.get(F.getKey()));
        assertEquals(6, _map.size());
    }

    public void testSetExistingKey() {
        assertEquals(4, _map.size());
        assertEquals(C.getValue(), _map.set(C.getKey(), "cvalue2"));
        assertEquals("cvalue2", _map.get(C.getKey()));
        assertEquals(4, _map.size());
    }

    public void testDeleteExisting() {
        assertEquals(4, _map.size());

        assertEquals(B.getValue(), _map.delete(B.getKey()));
        assertFalse(_map.contains(B.getKey()));
        assertEquals(3, _map.size());

        assertEquals(A.getValue(), _map.delete(A.getKey()));
        assertFalse(_map.contains(A.getKey()));
        assertEquals(2, _map.size());

        assertEquals(C.getValue(), _map.delete(C.getKey()));
        assertFalse(_map.contains(C.getKey()));
        assertEquals(1, _map.size());

        assertEquals(D.getValue(), _map.delete(D.getKey()));
        assertFalse(_map.contains(D.getKey()));
        assertEquals(0, _map.size());
    }

    public void testDeleteNonExisting() {
        assertEquals(4, _map.size());
        assertNull(_map.delete(E.getKey()));
        assertEquals(4, _map.size());
        assertNull(_map.delete(F.getKey()));
        assertEquals(4, _map.size());
    }

    public void testClear() {
        assertEquals(4, _map.size());
        assertFalse(_map.isEmpty());

        _map.clear();

        assertEquals(0, _map.size());
        assertTrue(_map.isEmpty());

        assertFalse(_map.contains(A.getKey()));
        assertFalse(_map.contains(B.getKey()));
        assertFalse(_map.contains(C.getKey()));
        assertFalse(_map.contains(D.getKey()));
    }

    public void testIteratorForwards() {
        checkIterator(_map.iterator());
    }

    private void checkIterator(Iterator i) {
        List entries = new LinkedList<>();

        for ( ; i.hasNext(); ) {
            Map.Entry entry = (Map.Entry) i.next();
            entries.add(new DefaultMapEntry(entry.getKey(), entry.getValue()));
        }

        try {
            i.next();
            fail();
        } catch (NoSuchElementException e) {
            // expected
        }

        assertEquals(4, entries.size());
        assertTrue(entries.contains(A));
        assertTrue(entries.contains(B));
        assertTrue(entries.contains(C));
        assertTrue(entries.contains(D));
    }
}