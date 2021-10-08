package com.company.builder;

import com.company.classes.Patient;
import com.company.interfaces.PatientBuilderInterface;
import com.company.interfaces.UserBuilderInterface;

public class PatientBuilder implements PatientBuilderInterface, UserBuilderInterface {
    private Patient patient;

    @Override
    public void addReason(String reason) {
        this.patient.setReason(reason);
    }

    @Override
    public Patient getPatient() {
        return this.patient;
    }

    @Override
    public void createUser() {
        this.patient = new Patient();
    }

    @Override
    public void addFirstName(String firstName) {
        this.patient.setFirstName(firstName);
    }

    @Override
    public void addLastName(String lastName) {
        this.patient.setLastName(lastName);
    }

    @Override
    public void addAge(int age) {
        this.patient.setAge(age);
    }
}
