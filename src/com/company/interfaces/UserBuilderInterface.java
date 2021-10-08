package com.company.interfaces;

import com.company.classes.User;

public interface UserBuilderInterface {
    void createUser();

    void addFirstName(String firstName);

    void addLastName(String lastName);

    void addAge(int age);
}
