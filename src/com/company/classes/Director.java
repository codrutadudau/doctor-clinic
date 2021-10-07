package com.company.classes;

import com.company.util.DoctorUtil;

import java.util.ArrayList;

public class Director {
    private DoctorUtil doctorTrait = new DoctorUtil();

    public User buildDoctor(UserBuilder userBuilder, ArrayList identificationNumbersList){
        int identificationNumber = doctorTrait.generateIdentificationNumber();
        while (identificationNumbersList.contains(identificationNumber)) {
            identificationNumber = doctorTrait.generateIdentificationNumber();
        }

        identificationNumbersList.add(identificationNumber);

        userBuilder
                .createUser()
                .addFirstName(doctorTrait.generateFirstName())
                .addLastName(doctorTrait.generateLastName())
                .addAge(doctorTrait.generateAge())
                .addIdentificationNumber(identificationNumber);

        return userBuilder.getUser();
    }
}
