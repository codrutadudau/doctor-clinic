package com.company;

import com.company.builder.Director;
import com.company.builder.DoctorBuilder;
import com.company.builder.PatientBuilder;
import com.company.iterator.PatientIterator;
import com.company.list.DoctorList;
import com.company.constants.DoctorConstants;
import com.company.constants.PatientConstants;
import com.company.iterator.DoctorIterator;
import com.company.list.PatientList;
import com.company.util.FileProcessor;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        DoctorBuilder doctorBuilder = new DoctorBuilder();
        PatientBuilder patientBuilder = new PatientBuilder();
        Director director = new Director();
        DoctorList doctorList = new DoctorList();
        PatientList patientList = new PatientList();
        FileProcessor fileProcessor = new FileProcessor();

        //Doctor

        ArrayList<Integer> identificationNumbersList = new ArrayList<>();

        for (int i = 0; i < DoctorConstants.STAFF_SIZE; i++) {
            doctorList.add(director.buildDoctor(doctorBuilder, identificationNumbersList));
        }

        DoctorIterator doctorIterator = doctorList.createIterator();

        while (doctorIterator.hasNext()) {
            System.out.println("Doctor: " + doctorIterator.current());
            doctorIterator.next();
        }

        System.out.println(" ");

        //Patient

        for (int i = 0; i < PatientConstants.POOL_SIZE; i++) {
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

        System.out.println(" ");

        //Print patient list based on their age category

        System.out.println(patientGroupsByAgeCategory);

        System.out.println(" ");

        //Write doctor list to file

        String writeDoctorListToFile = new Gson().toJson(doctorList);
        fileProcessor.writeDataToFile(writeDoctorListToFile, "./json/doctor.json");

        //Read doctor list from file

        Map<?, ?> readDoctorDataFromFile = fileProcessor.readDataFromFile("./json/doctor.json");
        for (Map.Entry<?, ?> entry : readDoctorDataFromFile.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        //Write patient list to file

//        String writePatientListToFile = new Gson().toJson(patientList);
//        fileProcessor.writeDataToFile(writePatientListToFile, "./json/patient.json");

        //Read doctor list from file

//        Map<?, ?> readPatientDataFromFile = fileProcessor.readDataFromFile("./json/patient.json");
//        for (Map.Entry<?, ?> entry : readPatientDataFromFile.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }


//        Patient patient = new Patient();
//        patient.setFirstName("asdasd");
//        patient.setLastName("tyewrwer");
//        patient.setAge(12);
//        patient.setReason(PatientConstants.REASONS[2]);
//        Doctor doctor = new Doctor();
//        doctor.setFirstName("123123");
//        doctor.setLastName("44444");
//        doctor.setAge(55);
//        doctor.setIdentificationNumber(555);
//        System.out.println(doctor.consult(patient));
    }
}
