package com.company.interfaces;

import com.company.classes.Patient;

public interface PatientBuilderInterface {
    void addReason(String reason);

    Patient getPatient();
}
