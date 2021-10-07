package com.company;

import com.company.classes.Director;
import com.company.classes.UserList;
import com.company.classes.UserBuilder;
import com.company.constants.DoctorConstants;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder();
        Director director = new Director();
        UserList userList = new UserList();

        ArrayList identificationNumbersList = new ArrayList();


        for (int i = 0; i < DoctorConstants.STAFF_SIZE; i++) {
            userList.add(director.buildDoctor(userBuilder, identificationNumbersList));
        }

        UserList.UserIterator userIterator = userList.createIterator();
        while (userIterator.hasNext()) {
            System.out.println("Doctor: " + userIterator.current());
            userIterator.next();
        }
    }
}
