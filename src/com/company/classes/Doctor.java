package com.company.classes;

public class Doctor extends User {
    private int identificationNumber;

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String consult(Patient patient) {
        return "the doctor with the id " + this.identificationNumber + " consulted the patient " + patient.getFirstName() + " " + patient.getLastName();
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.identificationNumber;
    }
}
