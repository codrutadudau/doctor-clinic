package com.company;

import com.company.builder.Director;
import com.company.builder.DoctorBuilder;
import com.company.builder.PatientBuilder;
import com.company.classes.Doctor;
import com.company.classes.Patient;
import com.company.iterator.PatientIterator;
import com.company.list.DoctorList;
import com.company.constants.DoctorConstants;
import com.company.constants.PatientConstants;
import com.company.iterator.DoctorIterator;
import com.company.list.PatientList;
import com.company.util.FileProcessor;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        System.out.println("List of Doctors\n");

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

        System.out.println("List of Patients\n");

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

        System.out.println("List of Patients Based on their Age Category\n");

        System.out.println(patientGroupsByAgeCategory);

        System.out.println(" ");

        //Write doctor list to file

        String writeDoctorListToFile = new Gson().toJson(doctorList);
        fileProcessor.writeDataToFile(writeDoctorListToFile, "./json/doctor.json");

        //Read doctor list from file

        System.out.println("Read Doctor List from File\n");

        JsonReader doctorReader = fileProcessor.readDataFromFile("./json/doctor.json");
        DoctorList doctorData = new Gson().fromJson(doctorReader, DoctorList.class);
        for (Doctor doctor : doctorData.getList()) {
            System.out.println(doctor.toString());
        }

        System.out.println(" ");

        //Write patient list to file

        String patientListJson = new Gson().toJson(patientList);
        fileProcessor.writeDataToFile(patientListJson, "./json/patient.json");

        //Read doctor list from file

        System.out.println("Read Patient List from File\n");

        JsonReader patientReader = fileProcessor.readDataFromFile("./json/patient.json");
        PatientList patientData = new Gson().fromJson(patientReader, PatientList.class); // contains the whole reviews list
        for (Patient patient : patientData.getList()) {
            System.out.println(patient.toString());
        }


        //Patient patient = new Patient();
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
