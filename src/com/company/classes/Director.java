package com.company.classes;

import com.company.util.DoctorUtil;
import com.company.util.PatientUtil;

import java.util.ArrayList;

public class Director {
    private DoctorUtil doctorUtil = new DoctorUtil();
    private PatientUtil patientUtil = new PatientUtil();

    public User buildDoctor(UserBuilder userBuilder, ArrayList identificationNumbersList) {
        int identificationNumber = doctorUtil.generateIdentificationNumber();
        while (identificationNumbersList.contains(identificationNumber)) {
            identificationNumber = doctorUtil.generateIdentificationNumber();
        }

        identificationNumbersList.add(identificationNumber);

        userBuilder
                .createUser()
                .addFirstName(doctorUtil.generateFirstName())
                .addLastName(doctorUtil.generateLastName())
                .addAge(doctorUtil.generateAge())
                .addIdentificationNumber(identificationNumber);

        return userBuilder.getUser();
    }

    public User buildPatient(UserBuilder userBuilder) {
        userBuilder
                .createUser()
                .addFirstName(patientUtil.generateFirstName())
                .addLastName(patientUtil.generateLastName())
                .addAge(patientUtil.generateAge())
                .addReason(patientUtil.generateReason());

        return userBuilder.getUser();
    }
}
