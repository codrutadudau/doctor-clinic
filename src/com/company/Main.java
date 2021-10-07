package com.company;

import com.company.classes.Director;
import com.company.classes.UserList;
import com.company.classes.UserBuilder;
import com.company.constants.DoctorConstants;
import com.company.constants.PatientConstants;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder();
        Director director = new Director();
        UserList userDoctorList = new UserList();
        UserList userPatientList = new UserList();
        ArrayList identificationNumbersList = new ArrayList();

        for (int i = 0; i < DoctorConstants.STAFF_SIZE; i++) {
            userDoctorList.add(director.buildDoctor(userBuilder, identificationNumbersList));
        }

        UserList.UserIterator userDoctorIterator = userDoctorList.createIterator();

        while (userDoctorIterator.hasNext()) {
            System.out.println("Doctor: " + userDoctorIterator.current());
            userDoctorIterator.next();
        }

        for (int i = 0; i < PatientConstants.STAFF_SIZE; i++) {
            userPatientList.add(director.buildPatient(userBuilder));
        }

        UserList.UserIterator userPatientIterator = userPatientList.createIterator();

        while (userPatientIterator.hasNext()) {
            System.out.println("Patient: " + userPatientIterator.current());
            userPatientIterator.next();
        }
    }
}
