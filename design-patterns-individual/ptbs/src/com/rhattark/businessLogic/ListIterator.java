package com.rhattark.businessLogic;

/**
 * Iterator interface that is implemented in concrete classes
 * @Pattern Iterator
 */
public interface ListIterator {
    public abstract boolean hasNext();
    public abstract Object next();
    public abstract void moveToHead();
    public abstract void remove();
}
