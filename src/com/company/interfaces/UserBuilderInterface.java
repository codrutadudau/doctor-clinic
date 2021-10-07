package com.company.interfaces;

import com.company.classes.User;
import com.company.classes.UserBuilder;

public interface UserBuilderInterface {
    UserBuilder createUser();
    UserBuilder addFirstName(String firstName);
    UserBuilder addLastName(String firstName);
    UserBuilder addAge(int age);
    UserBuilder addIdentificationNumber(int identificationNumber);
    UserBuilder addReason(String reason);
    User getUser();
}
