package com.company;

import com.company.builder.Director;
import com.company.builder.DoctorBuilder;
import com.company.builder.PatientBuilder;
import com.company.classes.Doctor;
import com.company.classes.Patient;
import com.company.iterator.PatientIterator;
import com.company.list.DoctorList;
import com.company.constants.DoctorConsts;
import com.company.constants.PatientConsts;
import com.company.iterator.DoctorIterator;
import com.company.list.PatientList;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        DoctorBuilder doctorBuilder = new DoctorBuilder();
        PatientBuilder patientBuilder = new PatientBuilder();
        Director director = new Director();
        ArrayList<Integer> identificationNumbersList = new ArrayList<>();
        DoctorList doctorList = new DoctorList();
        PatientList patientList = new PatientList();

        for (int i = 0; i < DoctorConsts.STAFF_SIZE; i++) {
            doctorList.add(director.buildDoctor(doctorBuilder, identificationNumbersList));
        }

        DoctorIterator doctorIterator = doctorList.createIterator();

        while (doctorIterator.hasNext()) {
            System.out.println("Doctor: " + doctorIterator.current());
            doctorIterator.next();
        }

        System.out.println(" ");

        for (int i = 0; i < PatientConsts.POOL_SIZE; i++) {
            patientList.add(director.buildPatient(patientBuilder));
        }

        PatientIterator patientIterator = patientList.createIterator();

        HashMap<String, Integer> patientGroupsByAgeCategory = new HashMap<>();
        while (patientIterator.hasNext()) {
            if (patientGroupsByAgeCategory.containsKey(patientIterator.current().getAgeCategory())) {
                patientGroupsByAgeCategory.put(patientIterator.current().getAgeCategory(), patientGroupsByAgeCategory.get(patientIterator.current().getAgeCategory()) + 1);
            } else {
                patientGroupsByAgeCategory.put(patientIterator.current().getAgeCategory(), 1);
            }

            System.out.println("Patient: " + patientIterator.current());
            patientIterator.next();
        }
        
        System.out.println(patientGroupsByAgeCategory);


//        Patient patient = new Patient();
//        patient.setFirstName("asdasd");
//        patient.setLastName("tyewrwer");
//        patient.setAge(12);
//        patient.setReason(PatientConsts.REASONS[2]);
//        Doctor doctor = new Doctor();
//        doctor.setFirstName("123123");
//        doctor.setLastName("44444");
//        doctor.setAge(55);
//        doctor.setIdentificationNumber(555);
//        System.out.println(doctor.consult(patient));
    }
}
