package com.company.classes;

public class Doctor extends User {
    private int identificationNumber;

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.identificationNumber;
    }
}
