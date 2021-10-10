package com.company.interfaces;

import java.util.List;

public interface UserListInterface<E, T> {
    void add(E user);

    List<E> getList();

    T createIterator();
}
