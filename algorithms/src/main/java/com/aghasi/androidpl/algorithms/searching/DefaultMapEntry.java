package com.aghasi.androidpl.algorithms.searching;


import java.util.Map;

class DefaultMapEntry implements Map.Entry {

    private final Object _key;
    private Object _value;


    public DefaultMapEntry(Object key, Object value) {
        _key = key;
        setValue(value);
    }


    public Object getKey() {
        return _key;
    }


    public Object setValue(Object value) {
        Object oldValue = _value;
        _value = value;
        return oldValue;
    }


    public Object getValue() {
        return _value;
    }


    public int hashCode() {
        return _key.hashCode() ^ _value.hashCode();
    }


    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        DefaultMapEntry other = (DefaultMapEntry) object;
        return _key.equals(other._key) && _value.equals(other._value);
    }


    public String toString() {
        return _key + " = " + _value;
    }
}
