package com.company.interfaces;

import com.company.classes.User;

public interface IteratorInterface<E> {
    boolean hasNext();

    E current();

    void next();
}
