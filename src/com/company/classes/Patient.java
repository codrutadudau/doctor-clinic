package com.company.classes;

import com.company.constants.PatientConsts;

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
        if (age > PatientConsts.STUDENT_MAX_AGE_THRESHOLD) {
            return PatientConsts.ADULT;
        } else if (age <= PatientConsts.STUDENT_MAX_AGE_THRESHOLD && age > PatientConsts.PUPIL_MAX_AGE_THRESHOLD) {
            return PatientConsts.STUDENT;
        } else if (age <= PatientConsts.PUPIL_MAX_AGE_THRESHOLD && age > PatientConsts.CHILDREN_MAX_AGE_THRESHOLD) {
            return PatientConsts.PUPIL;
        } else {
            return PatientConsts.CHILDREN;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.reason;
    }
}
