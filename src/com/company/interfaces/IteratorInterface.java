package com.company.interfaces;

public interface IteratorInterface<E> {
    boolean hasNext();

    E current();

    void next();
}
