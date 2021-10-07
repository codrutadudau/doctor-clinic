package com.company.classes;

import com.company.interfaces.UserBuilderInterface;

public class UserBuilder implements UserBuilderInterface {
    private User user;

    @Override
    public UserBuilder createUser() {
        this.user = new User();

        return this;
    }

    @Override
    public UserBuilder addFirstName(String firstName) {
        this.user.setFirstName(firstName);

        return this;
    }

    @Override
    public UserBuilder addLastName(String lastName) {
        user.setLastName(lastName);

        return this;
    }

    @Override
    public UserBuilder addAge(int age) {
        user.setAge(age);

        return this;
    }

    @Override
    public UserBuilder addIdentificationNumber(int identificationNumber) {
        user.setIdentificationNumber(identificationNumber);

        return this;
    }

    @Override
    public UserBuilder addReason(String reason) {
        user.setReason(reason);

        return this;
    }

    @Override
    public User getUser() {
        return this.user;
    }
}
