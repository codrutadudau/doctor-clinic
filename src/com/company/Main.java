package com.company;

import com.company.builder.Director;
import com.company.builder.DoctorBuilder;
import com.company.builder.PatientBuilder;
import com.company.classes.UserList;
import com.company.constants.DoctorConstants;
import com.company.constants.PatientConstants;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DoctorBuilder doctorBuilder = new DoctorBuilder();
        PatientBuilder patientBuilder = new PatientBuilder();
        Director director = new Director();
        UserList userDoctorList = new UserList();
        UserList userPatientList = new UserList();
        ArrayList identificationNumbersList = new ArrayList();

        for (int i = 0; i < DoctorConstants.STAFF_SIZE; i++) {
            userDoctorList.add(director.buildDoctor(doctorBuilder, identificationNumbersList));
        }

        UserList.UserIterator userDoctorIterator = userDoctorList.createIterator();

        while (userDoctorIterator.hasNext()) {
            System.out.println("Doctor: " + userDoctorIterator.current());
            userDoctorIterator.next();
        }

        System.out.println(" ");

        for (int i = 0; i < PatientConstants.STAFF_SIZE; i++) {
            userPatientList.add(director.buildPatient(patientBuilder));
        }

        UserList.UserIterator userPatientIterator = userPatientList.createIterator();

        while (userPatientIterator.hasNext()) {
            System.out.println("Patient: " + userPatientIterator.current());
            userPatientIterator.next();
        }
    }
}
