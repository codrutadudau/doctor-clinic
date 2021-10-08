package com.company.classes;

public class Patient extends User {
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAgeCategory() {
        int age = this.getAge();
        if (age > 18) {
            return "Adult";
        } else if (age <= 18 && age > 7) {
            return "Student";
        } else if (age <= 7 && age > 1) {
            return "Pupil";
        } else {
            return "Children";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.reason;
    }
}
