package com.aghasi.androidpl.mvvm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class PageStateObservable {

    private Set<PageStateObserver> _observers = new HashSet<>();
    private Map<String, Object> _statPairs = new HashMap<>();

    private final String[] STAT_KEYS;

    public PageStateObservable(String[] statKeys) {

        STAT_KEYS = statKeys;
    }

    public void addObserver(PageStateObserver observer) {

        _observers.add(observer);
    }

    public void deleteObserver(PageStateObserver observer) {

        _observers.remove(observer);
    }

    private void notifyObservers(String key) {

        for (PageStateObserver observer :
                _observers) {

            observer.update(this, key);
        }
    }

    public void putStat(String key, Object value) {

        if(!isKeyValid(key)) {
            throw new IllegalArgumentException("key parameter doesn't exist in page stats list.");
        }
        _statPairs.put(key, value);
        notifyObservers(key);
    }

    public Object getStat(String key) {

        if(!isKeyValid(key)) {
            throw new IllegalArgumentException("key parameter doesn't exist in page stats list.");
        }
        return _statPairs.get(key);
    }

    public boolean isKeyValid(String key) {

        for (String statKey :
                STAT_KEYS) {
            if (statKey.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
