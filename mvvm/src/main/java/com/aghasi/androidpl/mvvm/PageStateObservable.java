package com.aghasi.androidpl.mvvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;


public class PageStateObservable {

    private List<PageStateObserver> _observers = new ArrayList<>();
    private Map<String, Object> _statPairs = new ConcurrentHashMap<>();

    private final String[] STAT_KEYS;

    public PageStateObservable(String[] statKeys) {

        STAT_KEYS = statKeys;
    }

    public void addObserver(PageStateObserver observer) {

        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!_observers.contains(observer))
                _observers.add(observer);
        }
    }

    public void deleteObserver(PageStateObserver observer) {

        _observers.remove(observer);
    }

    private void notifyObservers(String key) {new Observable();

        for (PageStateObserver observer :
                _observers) {

            observer.update(this, key);
        }
    }

    synchronized public void putStat(String key, Object value) {

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
