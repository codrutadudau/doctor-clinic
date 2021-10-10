package com.company.interfaces;

import com.company.classes.Doctor;

public interface DoctorBuilderInterface {
    void addIdentificationNumber(int identificationNumber);

    Doctor getDoctor();
}
