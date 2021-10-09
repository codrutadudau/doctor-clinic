package com.company.builder;

import com.company.classes.Doctor;
import com.company.classes.Patient;
import com.company.util.DoctorUtil;
import com.company.util.PatientUtil;

import java.util.ArrayList;

public class Director {
    private final DoctorUtil doctorUtil = new DoctorUtil();
    private final PatientUtil patientUtil = new PatientUtil();

    public Doctor buildDoctor(DoctorBuilder doctorBuilder, ArrayList<Integer> identificationNumbersList) {
        int identificationNumber = doctorUtil.generateIdentificationNumber();
        while (identificationNumbersList.contains(identificationNumber)) {
            identificationNumber = doctorUtil.generateIdentificationNumber();
        }

        identificationNumbersList.add(identificationNumber);

        doctorBuilder.createUser();
        doctorBuilder.addFirstName(doctorUtil.generateFirstName());
        doctorBuilder.addLastName(doctorUtil.generateLastName());
        doctorBuilder.addAge(doctorUtil.generateAge());
        doctorBuilder.addIdentificationNumber(identificationNumber);

        return doctorBuilder.getDoctor();
    }

    public Patient buildPatient(PatientBuilder patientBuilder) {

        patientBuilder.createUser();
        patientBuilder.addFirstName(patientUtil.generateFirstName());
        patientBuilder.addLastName(patientUtil.generateLastName());
        patientBuilder.addAge(patientUtil.generateAge());
        patientBuilder.addReason(patientUtil.generateReason());

        return patientBuilder.getPatient();
    }
}
