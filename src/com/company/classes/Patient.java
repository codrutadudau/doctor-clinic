package com.company.classes;

import com.company.constants.PatientConstants;

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
        if (age > PatientConstants.STUDENT_MAX_AGE_THRESHOLD) {
            return PatientConstants.ADULT;
        } else if (age > PatientConstants.PUPIL_MAX_AGE_THRESHOLD) {
            return PatientConstants.STUDENT;
        } else if (age > PatientConstants.CHILDREN_MAX_AGE_THRESHOLD) {
            return PatientConstants.PUPIL;
        } else {
            return PatientConstants.CHILDREN;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.reason;
    }
}
