package com.company.interfaces;

import com.company.classes.User;

public interface IteratorInterface {
    boolean hasNext();

    User current();

    void next();
}
