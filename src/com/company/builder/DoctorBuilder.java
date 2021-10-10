package com.company.builder;

import com.company.classes.Doctor;
import com.company.interfaces.DoctorBuilderInterface;
import com.company.interfaces.UserBuilderInterface;

public class DoctorBuilder implements DoctorBuilderInterface, UserBuilderInterface {
    private Doctor doctor;

    @Override
    public void addIdentificationNumber(int identificationNumber) {
        this.doctor.setIdentificationNumber(identificationNumber);
    }

    @Override
    public Doctor getDoctor() {
        return this.doctor;
    }

    @Override
    public void createUser() {
        this.doctor = new Doctor();
    }

    @Override
    public void addFirstName(String firstName) {
        this.doctor.setFirstName(firstName);
    }

    @Override
    public void addLastName(String lastName) {
        this.doctor.setLastName(lastName);
    }

    @Override
    public void addAge(int age) {
        this.doctor.setAge(age);
    }
}
