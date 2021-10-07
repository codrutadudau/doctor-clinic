package com.company.classes;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private int identificationNumber;
    private String reason;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        while (this.reason != null) {
            return this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.reason;
        }

        return this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.identificationNumber;
    }
}
