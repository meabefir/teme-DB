package com.company;

import java.util.Vector;

public class Observable {
    Vector<Observer> obs;

    public Observable() {
        obs = new Vector<>();
    }

    public void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    public void notifyObservers(Object ob) {
        for (Observer o: obs) {
            o.update(this, ob);
        }
    }
}
