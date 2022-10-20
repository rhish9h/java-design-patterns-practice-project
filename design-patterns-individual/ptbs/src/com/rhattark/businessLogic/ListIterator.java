package com.rhattark.businessLogic;

public interface ListIterator {
    public abstract boolean hasNext();
    public abstract Object next();
    public abstract void moveToHead();
    public abstract void remove();
}
